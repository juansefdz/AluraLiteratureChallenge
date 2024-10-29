package com.juansefdz.LiterAlura.api.strategies;

import com.juansefdz.LiterAlura.infraestructure.api.GutendexApi;
import com.juansefdz.LiterAlura.infraestructure.services.BookService;

import java.util.Scanner;

public class SearchBooksByTitleStrategy implements MenuStrategy {
    private final BookService bookService;
    private final Scanner keyboardOption;

    public SearchBooksByTitleStrategy(BookService bookService, Scanner keyboardOption) {
        this.bookService = bookService;
        this.keyboardOption = keyboardOption;
    }

    @Override
    public void execute() {
        System.out.print("Enter the book title to search: ");
        String title = keyboardOption.nextLine();

        // Llamada al servicio para buscar libros por título
        String result = bookService.searchBooksByTitle(title);

        // Mostrar el resultado de la búsqueda
        System.out.println("Books found: " + result);
    }
}
