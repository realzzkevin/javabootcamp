package com.company;

import java.util.List;

public class ArrayFun {


    public int findAverage (List<Integer> list) {
        int returnVal = 0;
        for(int i : list) {
            returnVal += i;
            if (i < 0) {
                throw new IllegalArgumentException();
            }
        }
        return returnVal / list.size();
    }
}
