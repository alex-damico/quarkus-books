package it.dam.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.dam.entity.Book;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {

}
