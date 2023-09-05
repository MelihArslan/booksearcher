package nl.meliharslan.booksearcher.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.meliharslan.booksearcher.models.BookList;
import nl.meliharslan.booksearcher.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Transactional
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;


    @GetMapping("/search")
    public ResponseEntity<BookList> searchBooks(@RequestParam String query, @RequestParam String language, int limit) {
        BookList books = bookService.searchBooks(query, language, limit);
        return ResponseEntity.ok(books);
    }
}

