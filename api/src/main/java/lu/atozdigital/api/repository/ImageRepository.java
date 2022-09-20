package lu.atozdigital.api.repository;

import lu.atozdigital.api.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
