package lu.atozdigital.api.mapper;
import lu.atozdigital.api.dto.ArticleRequest;
import lu.atozdigital.api.dto.ArticleResponse;
import lu.atozdigital.api.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    @Mapping(target = "articleId", ignore = true)
    @Mapping(target = "articleName", source = "articleRequest.articleName")
    @Mapping(target = "price", source = "articleRequest.price")
    Article map(ArticleRequest articleRequest);
    @Mapping(target = "articleId", source = "articleId")
    @Mapping(target = "articleName", source = "articleName")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "images", expression = "java(article.getImages())")
    ArticleResponse mapToDto(Article article);
}
