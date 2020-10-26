package com.andrzej.stream.sand;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SandStorageTestSuite {

    @Test
    public void testGetSandBeansQuantity() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Africa());
        continents.add(new America());
        //When
        BigDecimal totalSand = BigDecimal.ZERO;
        for (SandStorage continent : continents) {
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }
        //Then
        BigDecimal expectedSand =new BigDecimal("11111111106444444444");
        assertEquals(expectedSand,totalSand);
    }

    @Test
    public void testGetSandBeansQuantityWithReduce() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Africa());
        continents.add(new America());
        //When
        BigDecimal totalSands = continents.stream()
                .map(continent -> continent.getSandBeansQuantity())
                .reduce(BigDecimal.ZERO,(sum, current) ->sum = sum.add(current));
        //Then
        BigDecimal expected = new BigDecimal("1000");
        assertEquals(expected,totalSands);

    }

}