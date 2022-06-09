package cloud.cholewa.photographs.adapters.rest;

import cloud.cholewa.photographs.domain.Album;
import cloud.cholewa.photographs.domain.AlbumRequest;
import cloud.cholewa.photographs.domain.CommentRequest;
import cloud.cholewa.photographs.domain.Photo;
import cloud.cholewa.photographs.domain.PhotoRequest;
import org.mapstruct.Mapper;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PhotographsRestMapper {

    PhotoRequest toDomain(PhotoDtoRequest photoDtoRequest);

    AlbumRequest toDomain(AlbumCreateRequest albumCreateRequest);

    CommentRequest toDomain(CommentCreateRequest commentCreateRequest);

    AlbumResponse toRest(Album album);

    default PhotoCommentsResponse toRest(Photo photo) {
        var comments = photo.getComments().stream()
                .map(comment -> CommentResponse.builder()
                        .date(comment.getDate())
                        .body(comment.getBody())
                        .build())
                .toList();

        return PhotoCommentsResponse.builder()
                .title(photo.getTitle())
                .description(photo.getDescription())
                .comments(comments)
                .build();
    }
}
