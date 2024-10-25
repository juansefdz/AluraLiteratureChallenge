package com.juansefdz.LiterAlura.infraestructure.services;

import com.juansefdz.LiterAlura.domain.entities.Book;
import com.juansefdz.LiterAlura.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooks(String title) {
        return bookRepository.findByTitle(title);
    }
}