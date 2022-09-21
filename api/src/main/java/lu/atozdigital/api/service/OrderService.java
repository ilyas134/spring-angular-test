package lu.atozdigital.api.service;



import lu.atozdigital.api.dto.OrderRequest;


import lu.atozdigital.api.dto.OrderResponse;
import lu.atozdigital.api.model.Article;
import lu.atozdigital.api.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrderService {
    public Order save(OrderRequest orderRequest);
    public List<OrderResponse> getAllOrders();
    public Order change(OrderRequest orderRequest,Long id);
    public List<Article> setArticles(Order order, OrderRequest orderRequest);

}
