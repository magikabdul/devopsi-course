package cloud.cholewa.photographs.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Comment {

    private Long id;
    private LocalDate date;
    private String body;
}
