package cloud.cholewa.photographs.adapters.rest;

import cloud.cholewa.photographs.commons.LocationUri;
import cloud.cholewa.photographs.domain.Photo;
import cloud.cholewa.photographs.ports.PhotographsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("album/{id}")
    public ResponseEntity<AlbumResponse> showAlbum(@PathVariable Long id) {
        var album = service.findAlbum(id);
        return ResponseEntity.ok(mapper.toRest(album));
    }

    @GetMapping("photo/{photoId}/album/{albumId}")
    public ResponseEntity<?> addToAlbum(@PathVariable Long photoId, @PathVariable Long albumId) {
        service.addPhotoToAlbum(photoId, albumId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("photo/{id}/comment")
    public ResponseEntity<Long> addComment(@PathVariable Long id, @Valid @RequestBody CommentCreateRequest commentCreateRequest) {
        return ResponseEntity.created(LocationUri.fromRequest(service.addComment(id, mapper.toDomain(commentCreateRequest))))
                .build();
    }

    @GetMapping("photo/{id}/comment")
    public ResponseEntity<PhotoCommentsResponse> getPhotoComments(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toRest(service.getPhotoWithComments(id)));
    }
}
