package cloud.cholewa.photographs.adapters.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class Uploader {

    private LocalDate date;
    private String name;
    private String phone;
    private String email;
    private String address;
}
