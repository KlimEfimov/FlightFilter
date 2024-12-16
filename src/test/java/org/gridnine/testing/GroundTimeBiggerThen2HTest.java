package org.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroundTimeBiggerThen2HTest {
    Query<Flight> query = new GroundTimeBiggerThen2H();

    @Test
    void givenNull_toExecute_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                query.execute(null));
    }

    @Test
    void givenListOfNulls_toExecute_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                query.execute(List.of(null, null, null)));
    }

    @Test
    void givenListWithMatchingFlights_toExecute_returnsCorrectList() {
        List<Flight> flights = FlightBuilder.createFlights();
        assertIterableEquals(Arrays.asList(
                flights.get(4), flights.get(5)), query.execute(flights));
    }

    @Test
    void givenListWithoutMatchingFlights_toExecute_returnsEmptyList() {
        List<Flight> flights = FlightBuilder.createFlights();
        ArrayList<Flight> arrayList = new ArrayList<>();
        arrayList.addAll(flights);
        arrayList.remove(5);
        arrayList.remove(4);
        assertIterableEquals(new ArrayList<Flight>(), query.execute(arrayList));
    }

}