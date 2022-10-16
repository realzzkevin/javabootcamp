package com.company;
import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number:");
        int ceiling = Integer.parseInt(scan.nextLine());

        boolean prime;

        for (int i = 2; i <= ceiling; i++) {
            prime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                System.out.println(i);
            }
        }
    }
}
