package cloud.cholewa.photographs.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class Photo {

    private Long id;
    private String title;
    private String description;
    private String name;
    private LocalDate date;
    private String phone;
    private String email;
    private String address;
    private List<String> tags;
    private String location;
    private PrivacyType privacy;
}
