package com.juansefdz.LiterAlura.api.strategies;

import java.util.List;
import java.util.Scanner;

import com.juansefdz.LiterAlura.domain.entities.Author;
import com.juansefdz.LiterAlura.infraestructure.services.AuthorService;

public class ListRegisteredAuthorsStrategy implements MenuStrategy {
    private final AuthorService authorService;
    private final Scanner keyboardOption = new Scanner(System.in);
    

    public ListRegisteredAuthorsStrategy(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void execute() {
        System.out.println("List of Registered Authors:");

        List<Author> authors = authorService.getAllAuthors(); 

        if (authors.isEmpty()) {
            System.out.println("No authors registered.");
        } else {
            for (Author author : authors) {
                System.out.println("Name: " + author.getName() +
                                   ", Birth Year: " + author.getBirthYear() +
                                   ", Death Year: " + author.getDeathYear());
            }
        }

        System.out.println("\nPress Enter to return to the main menu...");
        keyboardOption.nextLine();
        
    }
}
