package nl.meliharslan.booksearcher.converters;

import org.springframework.core.convert.converter.Converter;
import nl.meliharslan.booksearcher.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WsBookResponseToBookListConverter implements Converter<WsBookResponse, BookList> {

    @Override
    public BookList convert(WsBookResponse wsBookResponse) {
        // Create a BookList object and set its 'books' property using the extracted books
        BookList bookList = new BookList();
        bookList.setBooks(extractBooksFromResponse(wsBookResponse));
        return bookList;
    }

    // Helper method to extract books from the API response
    private List<Book> extractBooksFromResponse(WsBookResponse wsBookResponse) {
        return Optional.ofNullable(wsBookResponse.getItems())
                .orElse(new ArrayList<>())
                .stream()
                .map(this::mapToBook)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    // Helper method to map a WsBookItem to a Book object
    private Optional<Book> mapToBook(WsBookItem wsBookItem) {
        WsBookVolumeInfo volumeInfo = wsBookItem.getVolumeInfo();
        if (volumeInfo == null) {
            return Optional.empty();
        }

        // Create a new Book object and populate its properties
        Book book = new Book();
        book.setTitle(volumeInfo.getTitle());
        book.setAuthors(volumeInfo.getAuthors());
        book.setPublicationDate(volumeInfo.getPublishedDate());

        // Extract ISBN information if available
        List<IndustryIdentifier> industryIdentifiers = volumeInfo.getIndustryIdentifiers();
        if (industryIdentifiers != null) {
            Optional<IndustryIdentifier> isbn13Identifier = industryIdentifiers.stream()
                    .filter(identifier -> "ISBN_13".equals(identifier.getType()))
                    .findFirst();
            isbn13Identifier.ifPresent(identifier -> book.setIsbn(identifier.getIdentifier()));
        }

        return Optional.of(book);
    }
}
