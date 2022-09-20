package lu.atozdigital.api.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.atozdigital.api.dto.ArticleRequest;
import lu.atozdigital.api.mapper.ArticleMapper;
import lu.atozdigital.api.model.Article;
import lu.atozdigital.api.model.Image;
import lu.atozdigital.api.repository.ArticleRepository;
import lu.atozdigital.api.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.Kernel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ImageRepository imageRepository;
    private final ArticleMapper articleMapper;

    public Article save(ArticleRequest articleRequest, MultipartFile [] files) throws IOException {
        List <Image> images =new ArrayList<>();
        Article article=articleMapper.map(articleRequest);
        for (MultipartFile file:files
             ) {
            Image image=new Image();
            image.setName(file.getOriginalFilename());
            image.setType(file.getContentType());
            image.setPicture(file.getBytes());
            image.setArticle(article);
            images.add(image);
            imageRepository.save(image);
        }
        article.setImages(images);
        return articleRepository.save(article);
    }
}
