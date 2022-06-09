package cloud.cholewa.photographs.adapters.jpa;

import cloud.cholewa.photographs.adapters.jpa.entity.AlbumEntity;
import cloud.cholewa.photographs.adapters.jpa.entity.CommentEntity;
import cloud.cholewa.photographs.adapters.jpa.entity.PhotoEntity;
import cloud.cholewa.photographs.domain.Album;
import cloud.cholewa.photographs.domain.Comment;
import cloud.cholewa.photographs.domain.Photo;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotographsRepositoryMapper {

    default Photo toDomainSaved(PhotoEntity photoEntity) {
        return Photo.builder()
                .id(photoEntity.getId())
                .build();
    }

    default Album toDomainSaved(AlbumEntity albumEntity) {
        return Album.builder()
                .id(albumEntity.getId())
                .build();
    }

    default Comment toDomainSaved(CommentEntity commentEntity) {
        return Comment.builder()
                .id(commentEntity.getId())
                .build();
    }

    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Named("whenIterating")
    Photo toDomain(PhotoEntity photoEntity);

    @IterableMapping(elementTargetType = Photo.class, qualifiedByName = "whenIterating")
    List<Photo> toDomain(List<PhotoEntity> photoEntities);

    default Album toDomainFound(AlbumEntity albumEntity) {
        return Album.builder()
                .id(albumEntity.getId())
                .title(albumEntity.getTitle())
                .description(albumEntity.getDescription())
                .photos(toDomain(albumEntity.getPhotos()))
                .views(albumEntity.getViews())
                .build();
    }
}
