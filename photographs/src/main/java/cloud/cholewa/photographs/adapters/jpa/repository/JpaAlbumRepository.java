package cloud.cholewa.photographs.adapters.jpa.repository;

import cloud.cholewa.photographs.adapters.jpa.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
