package nl.meliharslan.booksearcher.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WsBookItem {
    private WsBookVolumeInfo volumeInfo;
}
