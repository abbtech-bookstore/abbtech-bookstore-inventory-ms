package org.abbtech.practice.controller;

import lombok.RequiredArgsConstructor;
import org.abbtech.practice.entity.Book;
import org.abbtech.practice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Validated
public class BookController {

    private final BookService bookService;
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/")
    public String sendBook(@RequestParam(value = "orderId", required = false) String orderId){
        System.out.println("send a book " + orderId);
        return "book sent";
    }
}
