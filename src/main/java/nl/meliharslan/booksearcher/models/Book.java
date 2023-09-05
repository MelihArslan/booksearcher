package nl.meliharslan.booksearcher.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private List<String> authors;
    private String isbn;
    private String publicationDate;
}

