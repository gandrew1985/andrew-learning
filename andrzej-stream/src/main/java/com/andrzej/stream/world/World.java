package com.andrzej.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

    public List<Continent> continents = new ArrayList<>();

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public boolean removeContinent(Continent continent) {
        return continents.remove(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continents -> continents.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public List<Continent> getContinents() {
        return continents;
    }
}
