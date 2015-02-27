package com.dojo.binarysearch;

import java.util.Arrays;

public class RecursiveSearch {


    public int indexOf(int[] list, int searchedItem, int index) {
        int length = list.length;
        if (length == 0 ) return -1;
        if (length == 1 ) {
            if ( searchedItem == list[0]){
                return index;
            }else{
                return -1;
            }
        }
        int split = length / 2;
        if (list[split] > searchedItem) {
            return indexOf(Arrays.copyOfRange(list, 0, split), searchedItem, index);
        }else{
            return indexOf(Arrays.copyOfRange(list, split, length), searchedItem, split + index);
        }
    }
}
