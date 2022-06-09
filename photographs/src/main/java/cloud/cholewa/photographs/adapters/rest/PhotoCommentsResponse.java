package cloud.cholewa.photographs.adapters.rest;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PhotoCommentsResponse {

    private String title;
    private String description;
    private List<CommentResponse> comments;
}
