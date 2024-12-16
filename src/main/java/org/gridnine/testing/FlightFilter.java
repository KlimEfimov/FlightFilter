package org.gridnine.testing;

import java.util.List;

/**
 * Flight parametrized implementation of the Filter interface.
 */
public class FlightFilter implements Filter<Flight> {
    @Override
    public List<Flight> start(List<Flight> input, Query<Flight> query) {
        return query.execute(input);
    }
}
