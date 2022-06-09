package cloud.cholewa.photographs.commons;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorResponse {

    LocalDateTime timestamp = LocalDateTime.now();
    String message;
}
