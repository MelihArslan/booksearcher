package nl.meliharslan.booksearcher.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WsBookVolumeInfo {
    private String title;
    private List<String> authors;
    private String publishedDate;
    private List<IndustryIdentifier> industryIdentifiers;
}

