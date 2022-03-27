package cloud.cholewa.exchange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatesTable {

    @JsonProperty("table")
    public String table;
    @JsonProperty("no")
    public String no;
    @JsonProperty("effectiveDate")
    public String effectiveDate;
    @JsonProperty("rates")
    public List<Rate> rates = new ArrayList<>();
}
