package com.juansefdz.LiterAlura.api.strategies;

import java.util.Scanner;

public class ListBooksByLanguageStrategy implements MenuStrategy {
    private final Scanner keyboardOption;

    public ListBooksByLanguageStrategy(Scanner keyboardOption) {
        this.keyboardOption = keyboardOption;
    }

    public void execute() {
        System.out.print("Enter the language to filter books: ");
        String language = keyboardOption.nextLine();
        System.out.println(language);
    }
}