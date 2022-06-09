package cloud.cholewa.photographs.domain;

import cloud.cholewa.photographs.adapters.rest.AlbumResponse;
import cloud.cholewa.photographs.ports.DateProvider;
import cloud.cholewa.photographs.ports.PhotographsRepository;
import cloud.cholewa.photographs.ports.PhotographsService;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class PhotographsServiceImpl implements PhotographsService {

    private final DateProvider dateProvider;
    private final PhotographsRepository repository;

    @Override
    public Long addPhoto(PhotoRequest photoRequest) {
        var photo = Photo.builder()
                .title(photoRequest.getTitle())
                .description(photoRequest.getDescription())
                .name(photoRequest.getName())
                .phone(photoRequest.getPhone())
                .email(photoRequest.getEmail())
                .address(photoRequest.getAddress())
                .tags(Arrays.asList(photoRequest.getTags().split(",")))
                .location(photoRequest.getLocation())
                .date(dateProvider.getDate())
                .privacy(PrivacyType.PUBLIC)
                .build();

        var savedPhoto = repository.addPhoto(photo);
        return savedPhoto.getId();
    }

    @Override
    public Long createAlbum(AlbumRequest albumRequest) {
        var album = Album.builder()
                .title(albumRequest.getTitle())
                .description(albumRequest.getDescription())
                .build();

        var savedAlbum = repository.addAlbum(album);

        return savedAlbum.getId();
    }

    @Override
    public Album findAlbum(Long id) {
        var album = repository.findAlbum(id).orElseThrow(() -> new PhotographsException("Album not found"));
        album.setViews(album.getViews() + 1);
        repository.updateAlbum(album);
        return album;
    }
}
