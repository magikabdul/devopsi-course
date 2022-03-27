package cloud.cholewa.clinic.patient.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Patient {

    private String pesel;
    private String firstName;
    private String lastName;
    private String phone;
    private String details;
}
