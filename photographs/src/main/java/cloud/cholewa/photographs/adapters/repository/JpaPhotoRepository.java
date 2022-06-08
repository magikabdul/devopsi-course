package cloud.cholewa.photographs.adapters.repository;

import cloud.cholewa.photographs.adapters.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPhotoRepository extends JpaRepository<PhotoEntity, Long> {
}
