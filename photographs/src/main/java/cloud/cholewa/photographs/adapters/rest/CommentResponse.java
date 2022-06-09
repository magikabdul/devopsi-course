package cloud.cholewa.photographs.adapters.rest;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CommentResponse {
    private LocalDate date;
    private String body;
}
