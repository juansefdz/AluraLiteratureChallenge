package com.juansefdz.LiterAlura.api.strategies;

import java.util.Scanner;

public class ShowStatisticsStrategy implements MenuStrategy {
    private final Scanner keyboardOption = new Scanner(System.in);
    
    public void execute() {
        System.out.println("Statistics:");
        System.out.println("not implemented yet");

        System.out.println("\nPress Enter to return to the main menu...");
        keyboardOption.nextLine();
        
    }
}