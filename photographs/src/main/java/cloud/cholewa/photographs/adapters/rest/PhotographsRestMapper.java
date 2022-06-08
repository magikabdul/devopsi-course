package cloud.cholewa.photographs.adapters.rest;

import cloud.cholewa.photographs.domain.AlbumRequest;
import cloud.cholewa.photographs.domain.PhotoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotographsRestMapper {

    PhotoRequest toDomain(PhotoDtoRequest photoDtoRequest);

    AlbumRequest toDomain(AlbumCreateRequest albumCreateRequest);
}
