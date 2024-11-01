package com.juansefdz.LiterAlura.infraestructure.services;

import org.springframework.stereotype.Service;

import com.juansefdz.LiterAlura.domain.entities.Author;
import com.juansefdz.LiterAlura.domain.repositories.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findAll().stream()
                .filter(author -> author.getBirthYear() != null && author.getBirthYear() <= year)
                .filter(author -> author.getDeathYear() == null || author.getDeathYear() >= year)
                .collect(Collectors.toList());
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
    
   
    public Author getOrCreateAuthorByName(Long id, String name, Integer birthYear, Integer deathYear) {
        return authorRepository.findByName(name)
                .orElseGet(() -> authorRepository.save(new Author(id, birthYear, deathYear, name)));
    }
}
