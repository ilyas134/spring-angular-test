package lu.atozdigital.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.atozdigital.api.dto.ArticleResponse;
import lu.atozdigital.api.dto.OrderRequest;
import lu.atozdigital.api.dto.OrderResponse;
import lu.atozdigital.api.model.Order;
import lu.atozdigital.api.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/Order/")
@AllArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest)  {
        Order order =orderService.save(orderRequest);
        return status(HttpStatus.CREATED).body(order);
    }
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return status(HttpStatus.OK).body(orderService.getAllOrders());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> changeOrder(@RequestBody OrderRequest orderRequest,@PathVariable Long id)  {
        Order order =orderService.change(orderRequest,id);
        return status(HttpStatus.CREATED).body(order);
    }
}
