package com.company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator cal;
    @Before

    public void setUp() {
        cal = new Calculator();

    }

    @Test
    public void shouldReturnSumOfNumbers() {
        int[] a1 = {1,2,3};
        int[] a2 = {4,5,6};
        int actualNumber = cal.sumArrays( a1, a2);
        int exceptingNumber = 21;

        assertEquals(exceptingNumber, actualNumber);

        int[] a3 = {};
        int[] a4 = {-3, 5,-4};
        assertEquals( -2, cal.sumArrays(a3, a4));
        assertEquals( 0, cal.sumArrays(a3, a3));
        assertEquals( 4, cal.sumArrays(a1, a4));
    }


    @Test
    public void shouldReturnArray() {
        int[] actualArray = cal.arrayify(6,7);
        int[] exceptingArray = {7,8,9,10,11,12};
        assertArrayEquals(exceptingArray, actualArray);
    }

}