package lu.atozdigital.api.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.atozdigital.api.dto.ArticleResponse;
import lu.atozdigital.api.dto.OrderRequest;

import lu.atozdigital.api.dto.OrderResponse;
import lu.atozdigital.api.exception.ArticleNotFoundException;
import lu.atozdigital.api.exception.OrderNotFoundException;
import lu.atozdigital.api.mapper.OrderMapper;
import lu.atozdigital.api.model.Article;
import lu.atozdigital.api.model.Order;
import lu.atozdigital.api.repository.ArticleRepository;
import lu.atozdigital.api.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class OrderService {
    private final ArticleRepository articleRepository;
    private final OrderRepository orderRepository;
    private OrderMapper orderMapper;
    public Order save(OrderRequest orderRequest)  {
        Order order =orderMapper.map(orderRequest);

        order.setArticles(setArticles(order,orderRequest));
        order.setUuid(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }
    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::mapToDto)
                .collect(toList());
    }
    public Order change(OrderRequest orderRequest,Long id)  {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id.toString()));

        order.setArticles(setArticles(order,orderRequest));
        order.setCreatedDate(Instant.now());
        return orderRepository.save(order);
    }
    public List<Article> setArticles(Order order,OrderRequest orderRequest){
        List <Article> articles =new ArrayList<>();
        for (Long articleId: orderRequest.getArticlesId()
        ) {
            Article article = articleRepository.findById(articleId)
                    .orElseThrow(() -> new ArticleNotFoundException(articleId.toString()));
            if(article.getOrders()!=null){
                article.getOrders().add(order);
            }else{
                article.setOrders(new ArrayList<>(Arrays.asList(order)));
            }

            articles.add(article);
        }
        return articles;
    }
}
