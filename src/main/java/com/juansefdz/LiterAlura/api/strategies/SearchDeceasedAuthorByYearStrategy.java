package com.juansefdz.LiterAlura.api.strategies;

import java.util.Scanner;

public class SearchDeceasedAuthorByYearStrategy  implements MenuStrategy{
    private final Scanner keyboardOption;

    public SearchDeceasedAuthorByYearStrategy(Scanner keyboardOption) {
        this.keyboardOption = keyboardOption;
    }

    public void execute() {
        System.out.print("Enter the year to filter deceased authors: ");
        int year = keyboardOption.nextInt();
        keyboardOption.nextLine(); // Limpiar el carácter de nueva línea
        // Lógica para buscar autores fallecidos en el año especificado
    }
}