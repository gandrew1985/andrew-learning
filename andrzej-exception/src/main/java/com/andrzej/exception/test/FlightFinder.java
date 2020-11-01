package com.andrzej.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFindException{
        Map<String, Boolean> flightList = new HashMap<>();
        flightList.put("Cracow",true);
        flightList.put("Warsaw", false);
        flightList.put("Rzeszow",true);

        if(flightList.containsKey(flight.getDestination())) {
            System.out.println("You can flight there");
        } else {
            throw new RouteNotFindException("Airport not found");
        }
    }
}
