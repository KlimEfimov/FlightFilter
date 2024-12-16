package org.gridnine.testing;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implementation of the Query interface to filter flights with ground time bigger than 2 hours.
 */
public class GroundTimeBiggerThen2H implements Query<Flight> {
    @Override
    public List<Flight> execute(List<Flight> input) {
        return Objects.requireNonNull(input)
                .stream()
                .filter(flight -> Objects.requireNonNull(flight).getSegments().size() > 1)
                .filter(GroundTimeBiggerThen2H::containGroundTimeAbove2H)
                .collect(Collectors.toList());
    }

    /**
     * Auxiliary method to check if flight contains more than 2 hours of ground time
     */
    private static boolean containGroundTimeAbove2H(Flight flight) {
        List<Segment> segments = flight.getSegments();
        ListIterator<Segment> iterator = segments.listIterator();
        Segment segment = iterator.next();
        boolean matchFound = false;
        while (!matchFound && iterator.hasNext()) {
            if (segment.getArrivalDate().plusHours(2).isBefore(iterator.next().getDepartureDate())) matchFound = true;
        }
        return matchFound;
    }
}
