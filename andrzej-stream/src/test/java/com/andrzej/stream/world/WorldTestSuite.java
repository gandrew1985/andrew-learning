package com.andrzej.stream.world;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Continent europa = new Continent();
        Continent america = new Continent();
        World world = new World();
        Country poland = new Country("Poland",new BigDecimal("40000000"));
        Country austria = new Country("Austra", new BigDecimal("20000000"));
        Country belgium = new Country("Belgium", new BigDecimal("15000000"));
        Country brazil = new Country("Brazil", new BigDecimal("100000000"));
        Country argentina = new Country("Argentina", new BigDecimal("50000000"));
        //When
        europa.addCountry(poland);
        europa.addCountry(austria);
        europa.addCountry(belgium);
        america.addCountry(brazil);
        america.addCountry(argentina);
        world.addContinent(europa);
        world.addContinent(america);

        BigDecimal totalPeople = world.getContinents().stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum, current) -> sum = sum.add(current));
        //Then
        BigDecimal expected = new BigDecimal("400000000");
        assertEquals(expected,totalPeople);

    }

}