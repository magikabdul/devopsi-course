package cloud.cholewa.photographs.adapters.repository;

import cloud.cholewa.photographs.adapters.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, Long> {
}
