package cloud.cholewa.photographs.adapters.jpa.repository;

import cloud.cholewa.photographs.adapters.jpa.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTagRepository extends JpaRepository<TagEntity, Long> {

    Optional<TagEntity> findByName(String name);
}
