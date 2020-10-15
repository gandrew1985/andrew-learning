package com.andrzej.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperatureStub implements Temperatures {
    @Override
    public Map<Integer, Double> getTemperatures() {
        Map<Integer, Double> stubResults = new HashMap<>();

        stubResults.put(0,21.0);
        stubResults.put(1,18.5);
        stubResults.put(2,20.2);
        stubResults.put(3,15.8);
        stubResults.put(4,18.4);
        return stubResults;
    }
}
