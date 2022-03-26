package cloud.cholewa.clinic.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PatientException.class)
    public ErrorResponse handlePatientException(PatientException e, HttpServletRequest request) {
        return new ErrorResponse(getSource(request), List.of(e.getMessage()));
    }


    private String getSource(HttpServletRequest request) {
        String DEFAULT_SOURCE_ERROR_MESSAGE = "Unknown source";

        try {
            return request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        } catch (Exception e) {
            return DEFAULT_SOURCE_ERROR_MESSAGE;
        }
    }
}
