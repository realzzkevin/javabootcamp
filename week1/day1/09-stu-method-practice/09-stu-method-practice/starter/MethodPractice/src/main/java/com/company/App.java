package com.company;

public class App {


	// subtract
    public static int subtract (int a, int b) {
        return a - b;
    }



	// subtractOrZero
    public static int subtractOrZero (int a, int b) {
        return b > a ? 0 : a-b;
    }


	// max
    public static int max (int a, int b, int c) {
        int max = a;
        if ( b > max) {
            max = b;
        }
        if (c > max ) {
            max = c;
        }
        return max;
    }



	// min
    public static int min (int a, int b, int c) {
        int m = a;
        if (b < m) {
            m = b;
        }
        if (c < m) {
            m = c;
        }
        return m;
    }



	// isLarger
    public static boolean isLarger (int a, int b) {
        return a > b;
    }



}
