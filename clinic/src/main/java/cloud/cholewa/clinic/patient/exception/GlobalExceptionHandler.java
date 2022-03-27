package cloud.cholewa.clinic.patient.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PatientException.class)
    public ErrorResponse handlePatientException(PatientException e, HttpServletRequest request) {
        return new ErrorResponse(getSource(request), List.of(e.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        return new ErrorResponse(getSource(request), List.of(Objects.requireNonNull(e.getMessage())));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleUnexpectedTypeException(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<String> errors = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return new ErrorResponse(getSource(request), errors);
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
