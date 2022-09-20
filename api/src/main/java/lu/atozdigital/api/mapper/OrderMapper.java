package lu.atozdigital.api.mapper;

import lu.atozdigital.api.dto.OrderRequest;
import lu.atozdigital.api.dto.OrderResponse;
import lu.atozdigital.api.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    Order map(OrderRequest orderRequest);
    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "createdDate", source = "createdDate")
    @Mapping(target = "articles", expression = "java(order.getArticles())")
    OrderResponse mapToDto(Order order);
}
