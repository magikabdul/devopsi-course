package cloud.cholewa.exchange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("code")
    private String code;

    @JsonProperty("mid")
    private Double mid;
}
