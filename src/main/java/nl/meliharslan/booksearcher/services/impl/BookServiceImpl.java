package nl.meliharslan.booksearcher.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.meliharslan.booksearcher.models.*;
import nl.meliharslan.booksearcher.services.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Value("${google.books.api.url}")
    private String googleBooksApiUrl;

    @Value("${google.books.api.key}")
    private String googleBooksApiKey;

    private final RestTemplate restTemplate;

    private final ConversionService conversionService;

    @Override
    public BookList searchBooks(String query, String language, int limit) {
        // Build the URI for the Google Books API request
        String apiUrl = buildApiUrl(query, language, limit);

        // Make an API request to retrieve a list of books
        ResponseEntity<WsBookResponse> response = restTemplate.getForEntity(apiUrl, WsBookResponse.class);

        // Convert the response to a list of Book objects using the ConversionService
        BookList books = conversionService.convert(response.getBody(), BookList.class);

        // Sort the BookList based on PublicationDates in ascending order
        if (books != null && books.getBooks() != null) {
            books.setBooks(books.getBooks().stream()
                    .sorted(Comparator.comparing(Book::getPublicationDate))
                    .collect(Collectors.toList()));

            // Format the PublicationDates using full Dutch month names
            books.getBooks().forEach(book -> {
                String formattedDate = formatPublicationDate(book.getPublicationDate());
                book.setPublicationDate(formattedDate);
            });
        }

        return books;
    }

    // Helper method to build the API URL
    private String buildApiUrl(String query, String language, int limit) {
        return UriComponentsBuilder.fromHttpUrl(googleBooksApiUrl)
                .queryParam("key", googleBooksApiKey)
                .queryParam("q", query)
                .queryParam("langRestrict", language)
                .queryParam("maxResults", limit)
                .queryParam("orderBy", "newest")
                .toUriString();
    }

    // Helper method to format the publication date
    private String formatPublicationDate(String date) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("nl", "NL"));
            return outputFormat.format(inputFormat.parse(date));
        } catch (Exception e) {
            log.error("Error formatting publication date: {}", e.getMessage());
            return date; // Return the original date in case of an error
        }
    }
}
