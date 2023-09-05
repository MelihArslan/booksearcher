package nl.meliharslan.booksearcher.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IndustryIdentifier {
    @JsonProperty("type")
    private String type;

    @JsonProperty("identifier")
    private String identifier;
}
