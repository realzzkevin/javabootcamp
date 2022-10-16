package com.comany;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class CalculatorTest {
    private Calculator cal;
    @Before
    public void setUp () {
        System.out.println("new calculator");
        cal = new Calculator();
    }
    @Test
    public void shouldDividePositiveNumbers( ) {
        assertEquals(7, cal.divide(42, 6));
        assertEquals(5, cal.divide(10, 2));
        System.out.println("test passed");
    }
     @Test
    public void shouldReturnZero() {
        assertEquals( 0, cal.divide(0,5));
        assertEquals(0, cal.divide(200, 0));
        System.out.println("test passed");
     }

     @Test
    public void shouldDivideNegativeNumbers() {
        assertEquals( -1, cal.divide(57, -57));
        assertEquals( -7, cal.divide(7, -1));
        System.out.println("test passed");
     }

     public void shouldDivideBothPosAndNeg() {

     }
}