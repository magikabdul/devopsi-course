package cloud.cholewa.photographs.adapters.rest;

import lombok.Data;

import java.util.List;

@Data
public class AlbumResponse {

    private String title;
    private String description;
    private int views;
    private List<PhotoAlbumResponse> photos;
}
