package com.juansefdz.LiterAlura.api.strategies;

import java.util.Scanner;

public class SearchAuthorByNameStrategy implements MenuStrategy {
    private final Scanner keyboardOption;

    public SearchAuthorByNameStrategy(Scanner keyboardOption) {
        this.keyboardOption = keyboardOption;
    }

    public void execute() {
        System.out.print("Enter the author's name to search: ");
        String author = keyboardOption.nextLine();
        // Lógica para buscar autor por nombre
    }
}
