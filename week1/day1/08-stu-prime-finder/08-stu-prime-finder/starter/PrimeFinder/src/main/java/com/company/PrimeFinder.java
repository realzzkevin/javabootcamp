package com.company;

import java.util.Scanner;
public class PrimeFinder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = 0;
        System.out.println("Please enter a number greater than 1");
        n = Integer.parseInt(myScanner.nextLine());
        if (n > 1) {
            int[] numbers = new int[n+1];
            for (int i = 0; i <= n; i++) {
                numbers[i] = i;
            }
            for (int i = 2; i <= (int)Math.sqrt(n+1); i++) {
                if( numbers[i] != -1) {
                    for (int j = i*i; j <= n; j += i ) {
                        numbers[j] = -1;
                    }
                }
            }
            for ( int i = 2; i <= n; i++) {
                if(numbers[i] != -1){
                    System.out.println(numbers[i]);
                }
            }
        }
    }
}
