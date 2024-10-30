package com.juansefdz.LiterAlura.api.strategies;

import java.util.Scanner;

public class ListAuthorsAliveInYearStrategy implements MenuStrategy{
    private final Scanner keyboardOption;

    public ListAuthorsAliveInYearStrategy(Scanner keyboardOption) {
        this.keyboardOption = keyboardOption;
    }

    public void execute() {
        System.out.print("Enter the year to filter authors: ");
        int year = keyboardOption.nextInt();
        keyboardOption.nextLine();
        System.out.println(year);
      
    }
}