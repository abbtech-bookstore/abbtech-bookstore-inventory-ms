package org.abbtech.practice.service;

import lombok.RequiredArgsConstructor;
import org.abbtech.practice.entity.Book;
import org.abbtech.practice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public Book addBook(Book book) {
        book.setId(UUID.randomUUID());
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Optional<Book> getBookById(UUID id) {
        return bookRepository.findById(id);
    }
}
