package cloud.cholewa.clinic.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PatientRequest {

    private static final String PHONE_PATTERN = "(?:(?:(?:\\+|00)?48)|(?:\\(\\+?48\\)))?(?:1[2-8]|2[2-69]|3[2-49]|4[1-8]|5[0-9]|6[0-35-9]|[7-8][1-9]|9[145])\\d{7}";
    private static final String PESEL_PATTERN = "^[0-9]{11}$";

    @NotBlank(message = "Missing pesel field")
    @Pattern(regexp = PESEL_PATTERN, message = "Invalid pesel field")
    private String pesel;

    @NotBlank(message = "Missing firstName field")
    @Size(min = 2, message = "firstName field cant be shorten that 2")
    private String firstName;

    @NotBlank(message = "Missing lastName field")
    @Size(min = 2, message = "lastName field cant be shorten that 2")
    private String lastName;

    @NotBlank(message = "Missing phone field")
    @Pattern(regexp = PHONE_PATTERN, message = "Invalid phone field")
    private String phone;

    private String details;
}
