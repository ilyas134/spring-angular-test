package lu.atozdigital.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lu.atozdigital.api.model.Image;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    private Long articleId;
    private String articleName;
    private Long price;
}
