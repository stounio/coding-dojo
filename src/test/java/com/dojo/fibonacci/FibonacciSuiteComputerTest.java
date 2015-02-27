package com.dojo.fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciSuiteComputerTest {

    private FibonacciSuiteComputer fibonacciSuiteComputer;

    @Before
    public void setUp() throws Exception {
        fibonacciSuiteComputer = new FibonacciSuiteComputer();

    }

    @Test
    public void shouldReturnAnEmptyArrayByDefault() throws Exception {
        assertEquals(0, fibonacciSuiteComputer.computeSuite(0).length);
    }


    @Test
    public void shouldReturnAnEmptyArrayWhenComputingForANegativeNumber(){
        assertEquals(0, fibonacciSuiteComputer.computeSuite(-1).length);
    }

    @Test
    public void shouldReturnAnArrayTheSizeOfTheAskedNumberOfElements() {
        assertEquals(8, fibonacciSuiteComputer.computeSuite(8).length);
    }

    @Test
    public void shouldBeOneForTheFirstElement() {
        assertEquals(1, fibonacciSuiteComputer.computeSuite(1)[0]);
    }

    @Test
    public void shouldBeOneForTheSecondElement() {
        assertEquals(1, fibonacciSuiteComputer.computeSuite(2)[1]);
    }

    @Test
    public void shouldTheValueOfOneElementBeTheSumOfThePreviousTwoElements() {
        int[] suite = fibonacciSuiteComputer.computeSuite(3);
        assertEquals(suite[0] + suite[1], suite[2]);
    }

    @Test
    public void shouldGenerateAValidSuiteForNElements(){
        int[] suite = fibonacciSuiteComputer.computeSuite(10);
        assertEquals(1, suite[0]);
        assertEquals(1, suite[1]);
        assertEquals(2, suite[2]);
        assertEquals(3, suite[3]);
        assertEquals(5, suite[4]);
        assertEquals(8, suite[5]);
        assertEquals(13, suite[6]);
        assertEquals(21, suite[7]);
        assertEquals(34, suite[8]);
        assertEquals(55, suite[9]);
    }

}
