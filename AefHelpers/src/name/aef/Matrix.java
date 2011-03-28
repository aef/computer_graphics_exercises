/*
 * Copyright © Alexander E. Fischer <aef@raxys.net>, 2010
 *
 * This file is part of AEF Helpers.
 */

package name.aef;

/**
 * A generic matrix class
 */
public class Matrix<T> {
    /**
     * Holds the values of the Matrix
     */
    protected T matrix[][];

    /**
     * Holds the fixed width of the Matrix
     */
    protected int width;

    /**
     * Holds the fixed height of the Matrix
     */
    protected int height;

    /**
     * Generates a new Matrix object
     *
     * @param width Width of the new Matrix
     * @param height Height of the new Matrix
     */
    public Matrix(int width, int height) {
        this.width  = width;
        this.height = height;
        matrix = (T[][])new Object[height][width];
    }

    /**
     * Returns the height
     *
     * @return Height of the Matrix
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the width
     *
     * @return Width of the Matrix
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets a value for the specified position in the Matrix
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param value Value to be set
     */
    public void set(int x, int y, T value) {
        matrix[y][x] = value;
    }

    /**
     * Returns the value for the specified position in the Matrix
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @return Value of the position
     */
    public T get(int x, int y) {
        return matrix[y][x];
    }

    /**
     * Returns true if the given coordinates are valid in this Matrix
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return false;
        }

        return true;
    }
}
