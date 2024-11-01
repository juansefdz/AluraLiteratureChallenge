package com.juansefdz.LiterAlura.api.strategies;


import java.util.List;
import java.util.Scanner;

import com.juansefdz.LiterAlura.api.dto.response.BookResponse;
import com.juansefdz.LiterAlura.infraestructure.services.BookService;

public class ListRegisteredBooksStrategy implements MenuStrategy {
    
    private final BookService bookService;

    private final Scanner keyboardOption = new Scanner(System.in);

    // Constructor para inyectar BookService
    public ListRegisteredBooksStrategy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void execute() {
        System.out.println("List of Registered Books:");

        
        List<BookResponse> books = bookService.getAllBooks(); 
        if (books.isEmpty()) {
            System.out.println("No registered books found.");
        } else {
            for (BookResponse book : books) {
                System.out.printf("ID: %d, Title: %s, Author: %s, Language: %s%n",
                        book.getId(), book.getTitle(), book.getAuthors(), book.getLanguages());
            }
        }
        System.out.println("\nPress Enter to return to the main menu...");
        keyboardOption.nextLine();
    }

   
}

