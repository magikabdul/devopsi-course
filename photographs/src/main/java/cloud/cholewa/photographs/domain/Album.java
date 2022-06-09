package cloud.cholewa.photographs.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Album {

    private Long id;
    private String title;
    private String description;
    private List<Photo> photos;
    private int views;

}
