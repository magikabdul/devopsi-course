package cloud.cholewa.photographs.ports;

import cloud.cholewa.photographs.domain.Album;
import cloud.cholewa.photographs.domain.AlbumRequest;
import cloud.cholewa.photographs.domain.PhotoRequest;

public interface PhotographsService {

    Long addPhoto(PhotoRequest photoRequest);

    Long createAlbum(AlbumRequest albumRequest);

    Album findAlbum(Long id);
}
