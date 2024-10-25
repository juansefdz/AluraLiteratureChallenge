package com.juansefdz.LiterAlura.main;

import java.util.Scanner;

import com.juansefdz.LiterAlura.domain.repositories.BookRepository;
import com.juansefdz.LiterAlura.infraestructure.api.GutendexApi;

public class Main {
   private Scanner keyboardOption = new Scanner(System.in);
   private GutendexApi gutendexApi = new GutendexApi();

   private final String URL_BASE = "https://gutendex.com/books/?search=";

    private BookRepository bookRepository;


   public Main (BookRepository bookRepository) {
       this.bookRepository = bookRepository;
   }

    public Main() {

    }

    public void menu() {
       int menuOption= -1;
       while (menuOption != 0) {
           System.out.println("""
               1 - Search Books
               2 - Find Book by Author
               3 - Statistics
               0 - Exit
               """);
           menuOption = keyboardOption.nextInt();
           keyboardOption.nextLine();

           switch (menuOption) {
               case 1 -> searchBooksByTitle();
               case 2 -> findBooksByAuthor();
               case 3 -> showStatistics();
               case 0 -> System.out.println("Exiting...");
               default -> System.out.println("Invalid option. Please try again.");
           }
       } while (menuOption != 0);
   }

    private void searchBooksByTitle() {
        System.out.print("Enter the book title to search: ");
        String title = keyboardOption.nextLine();
    }
    private void findBooksByAuthor() {
        System.out.print("Enter the author's name to search: ");
        String author = keyboardOption.nextLine();
    }
    private void showStatistics() {
        System.out.println("Statistics");
    }

}

