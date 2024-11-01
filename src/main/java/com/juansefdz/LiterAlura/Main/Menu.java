package com.juansefdz.LiterAlura.Main;

import com.juansefdz.LiterAlura.api.strategies.*;
import com.juansefdz.LiterAlura.infraestructure.api.GutendexApi;
import com.juansefdz.LiterAlura.infraestructure.services.AuthorService;
import com.juansefdz.LiterAlura.infraestructure.services.BookService;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class Menu {
    private final Scanner keyboardOption = new Scanner(System.in);
    
    @SuppressWarnings("unused")
    private final BookService bookService;
 
    private final Map<Integer, MenuStrategy> strategies = new HashMap<>();

    
    public Menu(GutendexApi gutendexApi, BookService bookService, AuthorService authorService) {
        this.bookService = bookService;

        strategies.put(1, new SearchBooksByTitleStrategy(bookService, keyboardOption));
        strategies.put(2, new ListRegisteredBooksStrategy(bookService));
        strategies.put(3, new ListRegisteredAuthorsStrategy(authorService));
        strategies.put(4, new ListAuthorsAliveInYearStrategy(keyboardOption));
        strategies.put(5, new ListBooksByLanguageStrategy(keyboardOption, bookService));
        strategies.put(6, new ShowStatisticsStrategy());
    }

    public void menu() {
        int menuOption = -1;
        while (menuOption != 0) {
            System.out.println("""
                *** LiterAlura ***
                1. Search Book by Title
                2. List Registered Books
                3. List Registered Authors
                4. List Authors Alive in a Given Year
                5. List Books by Language
                6. Generate Statistics
                
                0. Exit
                Choose an option ==>
                """);

            try {
                menuOption = keyboardOption.nextInt();
                keyboardOption.nextLine();

                if (menuOption == 0) {
                    System.out.println("Exiting...");
                    break;
                }

                MenuStrategy strategy = strategies.get(menuOption);
                if (strategy != null) {
                    strategy.execute();
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                keyboardOption.nextLine(); 
            }
        }
    }
}
