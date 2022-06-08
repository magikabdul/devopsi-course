package cloud.cholewa.photographs.ports;

import cloud.cholewa.photographs.domain.PhotoRequest;

public interface PhotographsService {

    Long addPhoto(PhotoRequest photoRequest);
}
