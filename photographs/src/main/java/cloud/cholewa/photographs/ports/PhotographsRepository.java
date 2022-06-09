package cloud.cholewa.photographs.ports;

import cloud.cholewa.photographs.domain.Album;
import cloud.cholewa.photographs.domain.Photo;

import java.util.Optional;

public interface PhotographsRepository {

    Photo addPhoto(Photo photo);

    Album addAlbum(Album album);

    Album updateAlbum(Album album);

    Optional<Album> findAlbum(Long id);
}
