package cloud.cholewa.photographs.commons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationUri {

    private static final String SEGMENT_SEPARATOR = "/";

    public static URI fromRequest(Object id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(SEGMENT_SEPARATOR + id)
                .build()
                .toUri();
    }
}
