package it.dam.service;

import it.dam.entity.Book;
import it.dam.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book create(Book book) {
        bookRepository.persist(book);
        return book;
    }

    public List<Book> findAll() {
        return bookRepository.findAll().stream().toList();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }
}
