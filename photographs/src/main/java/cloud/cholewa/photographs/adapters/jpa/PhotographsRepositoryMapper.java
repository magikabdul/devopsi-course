package cloud.cholewa.photographs.adapters.jpa;

import cloud.cholewa.photographs.adapters.jpa.entity.PhotoEntity;
import cloud.cholewa.photographs.domain.Photo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotographsRepositoryMapper {

    default Photo toDomainSaved(PhotoEntity photoEntity) {
        return Photo.builder()
                .id(photoEntity.getId())
                .build();
    }
}
