package cloud.cholewa.photographs.ports;

import cloud.cholewa.photographs.domain.Photo;

public interface PhotographsRepository {

    Photo addPhoto(Photo photo);
}
