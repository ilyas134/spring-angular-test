package lu.atozdigital.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.atozdigital.api.dto.ArticleRequest;
import lu.atozdigital.api.model.Article;
import lu.atozdigital.api.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/Article/")
@AllArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping(value={"/"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Article> createArticle(@RequestPart("article") ArticleRequest articleRequest, @RequestPart("imageFile")MultipartFile[]file)  {
        Article article =new Article();
        try {
             article= articleService.save(articleRequest,file);
        }catch (Exception exception){
            log.error("Exception occurred when saving article", exception);
        }
        return status(HttpStatus.CREATED).body(article);
    }
}
