package cloud.cholewa.photographs.adapters.rest;

import cloud.cholewa.photographs.domain.PhotoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhotographsRestMapper {

    PhotoRequest toDomain(PhotoDtoRequest photoDtoRequest);
}
