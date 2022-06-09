package cloud.cholewa.photographs.ports;

import cloud.cholewa.photographs.domain.Album;
import cloud.cholewa.photographs.domain.AlbumRequest;
import cloud.cholewa.photographs.domain.CommentRequest;
import cloud.cholewa.photographs.domain.Photo;
import cloud.cholewa.photographs.domain.PhotoRequest;

public interface PhotographsService {

    Long addPhoto(PhotoRequest photoRequest);

    Long createAlbum(AlbumRequest albumRequest);

    Album findAlbum(Long id);

    void addPhotoToAlbum(Long photoId, Long albumId);

    Long addComment(Long photoId, CommentRequest commentRequest);

    Photo getPhotoWithComments(Long id);
}
