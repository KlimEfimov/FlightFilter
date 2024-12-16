package org.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightFilter flightFilter = new FlightFilter();
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println(flightFilter.start(flights, new BeforeCurrentDate()));
        System.out.println(flightFilter.start(flights, new ArrivalBeforeDeparture()));
        System.out.println(flightFilter.start(flights, new GroundTimeBiggerThen2H()));
    }
}
