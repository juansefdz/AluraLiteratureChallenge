package com.juansefdz.LiterAlura.infraestructure.services;

import com.juansefdz.LiterAlura.api.dto.response.BookResponse;
import com.juansefdz.LiterAlura.api.dto.response.GutendexResponse;
import com.juansefdz.LiterAlura.domain.entities.Book;
import com.juansefdz.LiterAlura.infraestructure.api.GutendexApi;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService {
    private final GutendexApi gutendexApi;

    public BookService(GutendexApi gutendexApi) {
        this.gutendexApi = gutendexApi;
    }

    public List<BookResponse> searchBooksByTitle(String title) {
        GutendexResponse response = gutendexApi.searchBooksByTitle(title);
        List<Book> books = response.getResults();

        return books.stream()
                .map(book -> {
                    String authorName = book.getAuthor() != null && !book.getAuthor().isEmpty()
                            ? book.getAuthor().get(0)
                            : "Desconocido";

                    return BookResponse.builder()
                            .id(book.getId())
                            .title(book.getTitle())
                            .author(authorName)
                            .language(book.getLanguages() != null && !book.getLanguages().isEmpty()
                                    ? book.getLanguages().get(0)
                                    : "Desconocido")
                            .build();
                })
                .collect(Collectors.toList());
    }
}
