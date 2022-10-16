package com.company;

public class Calculator {

    public int sumArrays (int[] array1, int[] array2) {
        int result = 0;
        for (int i : array1) {
            result += i;
        }
        for (int i : array2) {
            result += i;
        }
        return result;

    }

    public int[] arrayify(int len, int start) {
        int [] a = new int[len];
        for(int i = 0; i < len; i++ ) {
            a[i] = start;
            start++;
        }
        return a;
    }
}
