package com.dojo.regex;

import junit.framework.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoneyFormatTest {

    @Test
    public void shouldTestForMoney() throws Exception {
        Pattern moneyPattern = Pattern.compile("^[A-Z]{3} (\\d{1,3})(,\\d{3})*\\.(\\d{2})");
        Matcher matcher = moneyPattern.matcher("GBP 123,456,789.99");
        assertTrue(matcher.matches());

        matcher = moneyPattern.matcher("GB 123456789");
        assertFalse(matcher.matches());

        matcher = moneyPattern.matcher("GBPUK 123456789");
        assertFalse(matcher.matches());

        matcher = moneyPattern.matcher("GBP 123,456,789.999");
        assertFalse(matcher.matches());

        matcher = moneyPattern.matcher("GBP 123,46,7.99");
        assertFalse(matcher.matches());

    }
}
