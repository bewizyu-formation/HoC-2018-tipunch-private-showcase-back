package fr.formation.upload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query(value = "SELECT * from image WHERE image.img_name = 'default.jpg'",
            nativeQuery = true)
    Image findDefaultImage();

    @Query(value = "SELECT * from image WHERE image.id = :id",
            nativeQuery = true)
    Image findImageById(@Param("id") Long id);
}
