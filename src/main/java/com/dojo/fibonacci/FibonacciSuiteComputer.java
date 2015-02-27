package com.dojo.fibonacci;

class FibonacciSuiteComputer {
     int[] computeSuite(int numberOfElements) {
         if(numberOfElements<0){
             return new int[0];
         }
        int[] suite = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            if (i < 2) {
                suite[i] = 1;
            } else {
                suite[i] = suite[i-2]+suite[i-1];
            }

        }
        return suite;
    }
}
