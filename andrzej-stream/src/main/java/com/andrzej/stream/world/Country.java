package com.andrzej.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public class Country {

    private String country;
    private BigDecimal peopleQuantity;

    public Country(String country, BigDecimal peopleQuantity) {
        this.country = country;
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country1 = (Country) o;

        if (!Objects.equals(country, country1.country)) return false;
        return Objects.equals(peopleQuantity, country1.peopleQuantity);
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (peopleQuantity != null ? peopleQuantity.hashCode() : 0);
        return result;
    }
}
