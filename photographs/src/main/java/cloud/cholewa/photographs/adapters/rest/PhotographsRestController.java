package cloud.cholewa.photographs.adapters.rest;

import cloud.cholewa.photographs.commons.LocationUri;
import cloud.cholewa.photographs.ports.PhotographsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("photographs")
public class PhotographsRestController {

    private final PhotographsService service;
    private final PhotographsRestMapper mapper;

    @PostMapping("photo")
    public ResponseEntity<Void> addPhoto(@Valid @RequestBody PhotoDtoRequest photoDtoRequest) {
        return ResponseEntity
                .created(LocationUri.fromRequest(service.addPhoto(mapper.toDomain(photoDtoRequest))))
                .build();
    }

    @PostMapping("album")
    public ResponseEntity<Void> createAlbum(@Valid @RequestBody AlbumCreateRequest albumCreateRequest) {
        return ResponseEntity
                .created(LocationUri.fromRequest(service.createAlbum(mapper.toDomain(albumCreateRequest))))
                .build();
    }

    @GetMapping("photo/album/{id}")
    public ResponseEntity<AlbumResponse> showAlbum(@PathVariable Long id) {
        return null;
    }

    @GetMapping("photo/{id}/album")
    public ResponseEntity<?> addToAlbum(@PathVariable Long id) {
        return null;
    }

    public ResponseEntity<?> addComment() {
        return null;
    }

    public ResponseEntity<?> addTag() {
        return null;
    }

    public ResponseEntity<?> getPhotoComments() {
        return null;
    }

    public ResponseEntity<?> getPhoto() {
        return null;
    }

    public ResponseEntity<?> getLocationPhotos() {
        return null;
    }
}
