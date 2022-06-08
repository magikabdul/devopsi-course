package cloud.cholewa.photographs.domain;

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
}
