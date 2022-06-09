package cloud.cholewa.photographs.adapters.jpa.repository;

import cloud.cholewa.photographs.adapters.jpa.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaPhotoRepository extends JpaRepository<PhotoEntity, Long> {

    @Query("SELECT p FROM PhotoEntity p JOIN p.comments c WHERE p.id=:id")
    Optional<PhotoEntity> findPhotoEntityByIdWithComments(@Param("id") Long id);
}
