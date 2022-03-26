package cloud.cholewa.clinic.patient.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String source;
    List<String> messages;
}
