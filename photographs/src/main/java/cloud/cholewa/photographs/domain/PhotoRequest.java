package cloud.cholewa.photographs.domain;

import lombok.Data;

@Data
public class PhotoRequest {

    private String title;
    private String description;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String tags;
    private String location;
}
