package com.company;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            /*if (i % 3 == 0) {
                if (i % 5 == 0) {
                    System.out.println("FIZZBUZZ");
                } else {
                    System.out.println("FIZZ");
                }
            } else if (i % 5 == 0) {
                System.out.println("BUZZ");
            } else {
                System.out.println(i);
            }*/
            String s = "";
            if (i % 3 == 0) {
                s += "FIZZ";
            }
            if (i % 5 == 0) {
                s += "BUZZ";
            }
            if(i % 3 != 0 && i % 5 != 0){
                s += i;
            }
            System.out.println(s);
        }
    }
}
