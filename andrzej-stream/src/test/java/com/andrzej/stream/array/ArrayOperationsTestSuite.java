package com.andrzej.stream.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] arrayNumbers = {3,4,7,5,3,6,8,12,57,34,23,45,14,11,12,76,23,23,54,21};
        //When
        double resultAvg = ArrayOperations.getAverage(arrayNumbers);

        //Then
        assertEquals(9.5,resultAvg,0);

    }

}