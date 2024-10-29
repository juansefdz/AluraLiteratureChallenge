package com.juansefdz.LiterAlura;

import com.juansefdz.LiterAlura.api.strategies.*;
import com.juansefdz.LiterAlura.infraestructure.api.GutendexApi;
import com.juansefdz.LiterAlura.infraestructure.services.BookService;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final Scanner keyboardOption = new Scanner(System.in);
    private final GutendexApi gutendexApi = new GutendexApi();
    private final BookService bookService = new BookService(gutendexApi);

    private final Map<Integer, MenuStrategy> strategies = new HashMap<>();

    public Main() {
        strategies.put(1, new SearchBooksByTitleStrategy(bookService, keyboardOption));
        strategies.put(2, new ListRegisteredBooksStrategy());
        strategies.put(3, new ListRegisteredAuthorsStrategy());
        strategies.put(4, new ListAuthorsAliveInYearStrategy(keyboardOption));
        strategies.put(5, new ListBooksByLanguageStrategy(keyboardOption));
        strategies.put(6, new ShowStatisticsStrategy());
        strategies.put(7, new ShowTop10BooksStrategy());
        strategies.put(8, new SearchAuthorByNameStrategy(keyboardOption));
        strategies.put(9, new SearchDeceasedAuthorByYearStrategy(keyboardOption));
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
                7. Top 10 Most Downloaded Books
                8. Search Author by Name
                9. Search Deceased Author by Year
                0. Exit
                Choose an option ==>
                """);

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
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
