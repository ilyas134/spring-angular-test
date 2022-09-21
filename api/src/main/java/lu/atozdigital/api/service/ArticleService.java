package lu.atozdigital.api.service;


import lu.atozdigital.api.dto.ArticleRequest;
import lu.atozdigital.api.dto.ArticleResponse;
import lu.atozdigital.api.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service

public interface ArticleService {
    public Article save(ArticleRequest articleRequest, MultipartFile[] files) throws IOException;
    public List<ArticleResponse> getAllArticles();
    public ArticleResponse getArticle(Long id);

}
