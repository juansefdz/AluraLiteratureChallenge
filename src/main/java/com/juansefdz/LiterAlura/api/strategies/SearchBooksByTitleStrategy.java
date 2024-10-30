package com.juansefdz.LiterAlura.api.strategies;

import com.juansefdz.LiterAlura.api.dto.response.BookResponse;
import com.juansefdz.LiterAlura.infraestructure.services.BookService;

import java.util.List;
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
        List<BookResponse> result = bookService.searchBooksByTitle(title);System.out.println("Book searched: " + title + "\n" + result.toString());;
        System.out.println("Book searched: " + title + "\n" + result);
        System.out.println("\nPress Enter to return to the main menu...");
        keyboardOption.nextLine();

    }
}
