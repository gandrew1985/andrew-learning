package com.andrzej.exception.test;

public class FlightMain {

    public static void main(String[] args) {
        Flight flight1 = new Flight("Cracow","London");
        Flight flight2 = new Flight("Rzeszow", "London");
        Flight flight3 = new Flight("London", "London");

        FlightFinder flightFinder = new FlightFinder();
        try {
            flightFinder.findFlight(flight1);
        } catch (RouteNotFindException e) {
            System.out.println(e);;
        } finally {
            System.out.println("Finish");
        }

        try {
            flightFinder.findFlight(flight3);
        } catch (RouteNotFindException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finish");
        }
    }
}
