package cloud.cholewa.photographs.adapters.jpa.repository;

import cloud.cholewa.photographs.adapters.jpa.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPhotoRepository extends JpaRepository<PhotoEntity, Long> {
}
