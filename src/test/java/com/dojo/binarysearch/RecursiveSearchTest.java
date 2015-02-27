package com.dojo.binarysearch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursiveSearchTest {

    private RecursiveSearch recursiveSearch;

    @Before
    public void setUp() throws Exception {
        recursiveSearch = new RecursiveSearch();
    }

    @Test
    public void shouldFindAnItemInSortedList() {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 14};
        Assert.assertEquals(6, recursiveSearch.indexOf(list, 7, 0));
    }

    @Test
    public void shouldReturnMinus1IfEmpty() {
        int[] list = new int[]{};
        Assert.assertEquals(-1, recursiveSearch.indexOf(list, 0, 0));
    }

    @Test
    public void shouldReturnMinus1IfNotFound() {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 14};
        Assert.assertEquals(-1, recursiveSearch.indexOf(list, 44, 0));
    }

    @Test
    public void shouldReturnIndexIfFound() {
        int[] list = new int[]{1, 2};
        Assert.assertEquals(1, recursiveSearch.indexOf(list, 2, 0));
    }

    @Test
    public void shouldReturnIndexIfFoundInListOfThree() {
        int[] list = new int[]{1, 2, 3};
        Assert.assertEquals(1, recursiveSearch.indexOf(list, 2, 0));
        Assert.assertEquals(2, recursiveSearch.indexOf(list, 3, 0));

    }

}
