package com.dojo.numbergenerator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class NumberGeneratorTest {


    private NumberGenerator numberGenerator;

    @Before
    public void setUp() throws Exception {
        numberGenerator = new NumberGenerator();
    }

    @Test(expected = NumberGeneratorException.class)
    public void shouldAcceptPositiveNumberOnly() throws Exception {
        numberGenerator.generate(-1);
    }

    @Test(expected = NumberGeneratorException.class)
    public void shouldAcceptSupportedNumbersOnly() throws Exception {
        numberGenerator.generate(20);
    }

    @Test
    public void shouldReturnOneFor1() throws Exception {
        assertThat(numberGenerator.generate(1), is("one"));
    }

    @Test
    public void shouldReturnNineFor9() throws Exception {
        assertThat(numberGenerator.generate(9), is("nine"));
    }


    @Test
    public void shouldReturnTenFor10() throws Exception {
        assertThat(numberGenerator.generate(10), is("ten"));
    }

    @Test
    public void shouldReturnSixteenFor16() throws Exception {
        assertThat(numberGenerator.generate(16), is("sixteen"));
    }

    @Test
    public void shouldReturnThirtyFor30() throws Exception {
        assertThat(numberGenerator.generate(30), is("thirty"));

    }

    private static class NumberGenerator {

        private static final String[] SINGLE_DIGITS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        private static final String[] DOUBLE_DIGITS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        public String generate(int number) throws NumberGeneratorException {
            if (number < 1) {
                throw new NumberGeneratorException("Accept positive number only");
            } else if (number > 9 && number < 20) {
                return DOUBLE_DIGITS[number - 10];
            } else if (number <= 9) {
                return SINGLE_DIGITS[number - 1];
            }
            throw new NumberGeneratorException("Number not supported");
        }
    }


    private static class NumberGeneratorException extends Exception {
        public NumberGeneratorException(String message) {
            super(message);
        }
    }
}
