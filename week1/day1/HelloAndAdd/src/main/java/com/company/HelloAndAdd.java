package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HelloAndAdd {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = myScanner.nextLine();
        System.out.println("Your name is " + name);
        System.out.println("Please enter a number.");
        int num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please enter another number");
        int num2 = Integer.parseInt(myScanner.nextLine());
        int sum = num1 + num2;
        System.out.println("The sum of those numbers is " + sum);

    }
}
