package com.company;

import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInput;
        int number = 0;

        do {
            try {
                System.out.println("Please enter a number between 1 and 10");
                userInput = scanner.nextLine();
                number = Integer.parseInt(userInput);
            } catch (NumberFormatException ex) {
                System.out.println("Sorry Dave, I can't do that");
            }

        } while(number < 1 || number > 10);

        System.out.println("Thanks for playing - you chose: " + number);
    }
}
