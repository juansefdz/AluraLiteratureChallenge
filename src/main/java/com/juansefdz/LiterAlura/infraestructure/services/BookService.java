package com.juansefdz.LiterAlura.infraestructure.services;


import com.juansefdz.LiterAlura.infraestructure.api.GutendexApi;

import org.springframework.stereotype.Service;



@Service
public class BookService {
    private final GutendexApi gutendexApi;

    public BookService(GutendexApi gutendexApi) {
        this.gutendexApi = gutendexApi;
    }

    public String searchBooksByTitle(String title) {
        // Llama al método `getBooksData` del `GutendexApi` con el título ingresado
        return gutendexApi.getBooksData(title);
    }
}
