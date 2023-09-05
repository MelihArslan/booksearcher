package nl.meliharslan.booksearcher.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

// Have to make nested classes because Google doesn't provide an official OpenAPI specification for automatic Java class generation ):
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WsBookResponse {
    private List<WsBookItem> items;
}
