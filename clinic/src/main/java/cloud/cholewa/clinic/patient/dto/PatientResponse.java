package cloud.cholewa.clinic.patient.dto;

import lombok.Data;

@Data
public class PatientResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String details;
}
