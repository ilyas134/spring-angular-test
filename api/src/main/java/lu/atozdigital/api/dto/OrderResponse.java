package lu.atozdigital.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lu.atozdigital.api.model.Article;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private String uuid= UUID.randomUUID().toString();
    private Instant createdDate;
    private List<Article> articles;
}
