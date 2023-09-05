package nl.meliharslan.booksearcher.services;

import nl.meliharslan.booksearcher.models.BookList;

public interface BookService {
    BookList searchBooks(String query, String language, int limit);
}
