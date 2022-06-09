package cloud.cholewa.photographs.adapters.rest;

import cloud.cholewa.photographs.domain.Album;
import cloud.cholewa.photographs.domain.AlbumRequest;
import cloud.cholewa.photographs.domain.CommentRequest;
import cloud.cholewa.photographs.domain.PhotoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotographsRestMapper {

    PhotoRequest toDomain(PhotoDtoRequest photoDtoRequest);

    AlbumRequest toDomain(AlbumCreateRequest albumCreateRequest);

    CommentRequest toDomain(CommentCreateRequest commentCreateRequest);

    AlbumResponse toRest(Album album);
}
