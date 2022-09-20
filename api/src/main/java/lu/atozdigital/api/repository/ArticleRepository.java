package lu.atozdigital.api.repository;

import lu.atozdigital.api.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
