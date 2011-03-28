/*
 * Copyright © Alexander E. Fischer <aef@raxys.net>, 2010
 *
 * This file is part of AEF Helpers.
 */

package name.aef;

/**
 * A special Matrix class which simulates not being limited in dimensions.
 *
 * Even returns a value for positions outside of the boundaries of the Matrix by finding the
 * nearest existing position's value.
 */
public class BorderlessMatrix<T> extends Matrix<T> {
    
    /**
     * Generates a new BorderlessMatrix object
     *
     * @param width Width of the new BorderlessMatrix
     * @param height Height of the new BorderlessMatrix
     */
    public BorderlessMatrix(int width, int height) {
        super(width, height);
    }

    /**
     * Returns the value for the specified position in or outside of the Matrix
     *
     * Even returns a value for positions outside of the boundaries of the Matrix by finding the
     * nearest existing position's value.
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @return Value of the position
     */
    @Override
    public T get(int x, int y) {
        int newX = x;
        int newY = y;

        if (newX < 0) {
            newX = 0;
        }

        if (newY < 0 ) {
            newY = 0;
        }

        if (newX >= width) {
            newX = width - 1;
        }

        if (newY >= height) {
            newY = height - 1;
        }

        if (newX == x && newY == y) {
           return matrix[y][x];
        }

        return get(newX, newY);
    }
}
