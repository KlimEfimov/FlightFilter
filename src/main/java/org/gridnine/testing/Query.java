package org.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface for filer queries.
 */
@FunctionalInterface
public interface Query<T> {
    static final LocalDateTime NOW = LocalDateTime.now();

    /**
     * Method with filtering logic.
     */
    List<T> execute(List<T> input);
}
