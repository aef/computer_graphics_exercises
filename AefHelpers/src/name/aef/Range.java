package name.aef;

/*
 * Copyright © Alexander E. Fischer <aef@raxys.net>, 2010
 *
 * This file is part of AEF Helpers.
 */

/**
 * A class for modelling numeric (and possibly other) ranges
 */
public class Range<T extends Comparable> {

    /**
     * Holds the lowest included value of the range
     */
    protected T minimum;

    /**
     * Holds the highest included value of the range
     */
    protected T maximum;

    /**
     * Generates a new Range
     *
     * @param minimum Lowest included value of the range
     * @param maximum Highest included value of the range
     */
    public Range(T minimum, T maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
     * Returns the highest included value of the range
     *
     * @return Highest included value of the range
     */
    public T getMaximum() {
        return maximum;
    }

    /**
     * Resets the highest included value of the range
     * 
     * @param maximum New highest included value of the range
     */
    public void setMaximum(T maximum) {
        this.maximum = maximum;
    }

    /**
     * Returns the lowest included value of the range
     *
     * @return Lowest included value of the range
     */
    public T getMinimum() {
        return minimum;
    }

    /**
     * Resets the lowest included value of the range
     *
     * @param minimum New lowest included value of the range
     */
    public void setMinimum(T minimum) {
        this.minimum = minimum;
    }

    /**
     * Checks if a given value is included in the range
     *
     * @param value The value to be checked for inclusion
     * @return true if included, false otherwise
     */
    public boolean isIncluded(T value) {
        if (minimum.compareTo(value) <= 0 &&
            maximum.compareTo(value) >= 0) {
            return true;
        }

        return false;
    }

    /**
     * Returns a human-readable String representation
     */
    @Override
    public String toString() {
        return String.format("#<%s: minimum: %d, maximum: %d>",
                             getClass(), getMinimum(), getMaximum());
    }
}
