package lu.atozdigital.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long orderId;
    private String uuid;
    private Instant createdDate;
    private List<Long> articlesId;
}
