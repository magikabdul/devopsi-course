package cloud.cholewa.photographs.adapters.repository;

import cloud.cholewa.photographs.adapters.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTagRepository extends JpaRepository<TagEntity, Long> {
}
