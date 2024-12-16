package org.gridnine.testing;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implementation of the Query interface to filter flights with departure time earlier than arrival time.
 */
public class ArrivalBeforeDeparture implements Query<Flight> {
    @Override
    public List<Flight> execute(List<Flight> input) {
        return Objects.requireNonNull(input)
                .stream()
                .filter(flight -> Objects.requireNonNull(flight).getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
