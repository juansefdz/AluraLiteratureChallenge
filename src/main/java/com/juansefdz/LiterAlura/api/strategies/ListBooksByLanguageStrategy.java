package com.juansefdz.LiterAlura.api.strategies;

import java.util.List;
import java.util.Scanner;

import com.juansefdz.LiterAlura.api.dto.response.BookResponse;
import com.juansefdz.LiterAlura.infraestructure.services.BookService;

public class ListBooksByLanguageStrategy implements MenuStrategy {
    private final Scanner keyboardOption;
    private final BookService bookService; 
    
    public ListBooksByLanguageStrategy(Scanner keyboardOption, BookService bookService) {
        this.keyboardOption = keyboardOption;
        this.bookService = bookService; 
    }

    public void execute() {
        System.out.println("""
                Choose a language:
                1. sp - spanish
                2. en - english
                3. fr - french
                4. ge - german
                5. it - italian
                choose any option :\s""");

        int option = keyboardOption.nextInt();
        keyboardOption.nextLine(); 

        String language;
        switch (option) {
            case 1 -> language = "sp";
            case 2 -> language = "en";
            case 3 -> language = "fr";
            case 4 -> language = "ge";
            case 5 -> language = "it";
            default -> {
                System.out.println("Invalid option");
                return; 
            }
        }

       
        List<BookResponse> books = bookService.getBooksByLanguage(language);
        if (books.isEmpty()) {
            System.out.println("could not find book with this language " + language);
        } else {
            System.out.println("Books found in the language " + language + ":");
            for (BookResponse book : books) {
                System.out.println("- " + book.getTitle()); 
                
            }

        }
        System.out.println("\nPress Enter to return to the main menu...");
        keyboardOption.nextLine();
    }
}
