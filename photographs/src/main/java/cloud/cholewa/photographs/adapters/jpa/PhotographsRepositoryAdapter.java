package cloud.cholewa.photographs.adapters.jpa;

import cloud.cholewa.photographs.adapters.jpa.entity.AlbumEntity;
import cloud.cholewa.photographs.adapters.jpa.entity.LocationEntity;
import cloud.cholewa.photographs.adapters.jpa.entity.PhotoEntity;
import cloud.cholewa.photographs.adapters.jpa.entity.TagEntity;
import cloud.cholewa.photographs.adapters.jpa.entity.Uploader;
import cloud.cholewa.photographs.adapters.jpa.repository.JpaAlbumRepository;
import cloud.cholewa.photographs.adapters.jpa.repository.JpaCommentRepository;
import cloud.cholewa.photographs.adapters.jpa.repository.JpaLocationRepository;
import cloud.cholewa.photographs.adapters.jpa.repository.JpaPhotoRepository;
import cloud.cholewa.photographs.adapters.jpa.repository.JpaTagRepository;
import cloud.cholewa.photographs.domain.Album;
import cloud.cholewa.photographs.domain.Photo;
import cloud.cholewa.photographs.ports.PhotographsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Transactional
@Component
@RequiredArgsConstructor
public class PhotographsRepositoryAdapter implements PhotographsRepository {

    private final JpaPhotoRepository photoRepository;
    private final JpaTagRepository tagRepository;
    private final JpaLocationRepository locationRepository;
    private final JpaCommentRepository commentRepository;
    private final JpaAlbumRepository albumRepository;
    private final PhotographsRepositoryMapper mapper;

    @Override
    public Album updateAlbum(Album album) {
        var albumEntity = albumRepository.findById(album.getId());

        albumEntity.ifPresent(entity -> entity.setViews(album.getViews()));

        return mapper.toDomainFound(albumRepository.save(albumEntity.get()));
    }

    @Override
    public Optional<Album> findAlbum(Long id) {
        var album = albumRepository.findById(id);
        return album.map(mapper::toDomainFound);
    }

    @Override
    public Album addAlbum(Album album) {
        var albumEntity = new AlbumEntity();
        albumEntity.setTitle(album.getTitle());
        albumEntity.setDescription(album.getDescription());

        var savedAlbum = albumRepository.save(albumEntity);

        return mapper.toDomainSaved(savedAlbum);
    }

    @Override
    public Photo addPhoto(Photo photo) {
        var locationEntity = new LocationEntity(photo.getLocation());
        var tagsEntity = new HashSet<TagEntity>();
        var tags = photo.getTags();

        for (String name : tags) {
            var tagEntity = tagRepository.findByName(name.trim());
            if (tagEntity.isPresent()) {
                tagsEntity.add(tagEntity.get());
            } else {
                tagsEntity.add(new TagEntity(name.trim()));
            }
        }

        var uploader = Uploader.builder()
                .date(photo.getDate())
                .name(photo.getName())
                .phone(photo.getPhone())
                .email(photo.getEmail())
                .address(photo.getAddress())
                .build();

        var photoToSave = new PhotoEntity();
        photoToSave.setTitle(photo.getTitle());
        photoToSave.setDescription(photo.getDescription());
        photoToSave.setPrivacy(photo.getPrivacy());
        photoToSave.setUploadHistory(uploader);
        photoToSave.setTags(tagsEntity);
        photoToSave.setLocation(locationEntity);

        locationEntity.addPhoto(photoToSave);
        tagsEntity.forEach(tagEntity -> tagEntity.addPhoto(photoToSave));

        locationRepository.save(locationEntity);
        tagRepository.saveAll(tagsEntity);

        return mapper.toDomainSaved(photoRepository.save(photoToSave));
    }
}
