package com.andrzej.exception.test;

public class Flight {

    private String destination;
    private String departure;

    public Flight(String destination, String departure) {
        this.destination = destination;
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }
}
