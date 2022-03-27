package cloud.cholewa.clinic.patient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PatientResponse {

    private String pesel;
    private String firstName;
    private String lastName;
    private String phone;
    private String details;
}
