package coud.cholewa.clinic.patient.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class Patient {

    private static final String PHONE_PATTERN = "^(45|5[0,1,3,7]|6[0,6,9]|7[2,3,8,9]|88)[0-9]{7}$";

    @NotEmpty
    private Long id;

    @NotEmpty
    @Size(min = 2)
    private String firstName;

    @NotEmpty
    @Size(min = 2)
    private String lastName;

    @Pattern(regexp = PHONE_PATTERN)
    private String phone;

    private String details;
}
