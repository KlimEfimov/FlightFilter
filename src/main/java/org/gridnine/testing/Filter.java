package org.gridnine.testing;

import java.util.List;

/**
 * Filtering interface.
 */

public interface Filter<T> {
    /**
     * Starts filtering
     */
    List<T> start(List<T> input, Query<T> query);
}
