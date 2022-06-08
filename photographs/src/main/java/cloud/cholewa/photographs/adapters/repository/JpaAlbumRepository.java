package cloud.cholewa.photographs.adapters.repository;

import cloud.cholewa.photographs.adapters.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
