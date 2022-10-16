package com.company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayFunTest {
    private ArrayFun fun;

    @Before
    public void setUp() {
        fun = new ArrayFun();
    }

    @Test
    public void shouldThrowException() {
        List<Integer> list = new ArrayList<Integer>();

        runnableT
        assertThrows( new IllegalArgumentException(), fun.findAverage(list));
    }

}