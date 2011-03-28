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

    public static Matrix<Double> translate2D(Double x, Double y) {
        Matrix rotateMatrix = new Matrix<Double>(1, 2);

        rotateMatrix.set(0, 0, x);
        rotateMatrix.set(0, 1, y);

        return rotateMatrix;
    }

    public static Matrix<Double> translate2Don3D(Double x, Double y) {
        Matrix translationMatrix = new Matrix<Double>(3, 3);

        translationMatrix.set(0, 0, 1.0);
        translationMatrix.set(0, 1, 0.0);
        translationMatrix.set(0, 2, 0.0);

        translationMatrix.set(1, 0, 0.0);
        translationMatrix.set(1, 1, 1.0);
        translationMatrix.set(1, 2, 0.0);

        translationMatrix.set(2, 0, x);
        translationMatrix.set(2, 1, y);
        translationMatrix.set(2, 2, 1.0);

        return translationMatrix;
    }

    public static Matrix<Double> scale2D(Double x, Double y) {
        Matrix scaleMatrix = new Matrix<Double>(2, 2);

        scaleMatrix.set(0, 0, x);
        scaleMatrix.set(0, 1, 0.0);
        scaleMatrix.set(1, 0, 0.0);
        scaleMatrix.set(1, 1, y);

        return scaleMatrix;
    }

    public static Matrix<Double> rotate2D(Double angle) {
        Matrix rotateMatrix = new Matrix<Double>(2, 2);

        rotateMatrix.set(0, 0, Math.cos(angle));
        rotateMatrix.set(0, 1, Math.sin(angle));
        rotateMatrix.set(1, 0, -Math.sin(angle));
        rotateMatrix.set(1, 1, Math.cos(angle));

        return rotateMatrix;
    }

    public static Matrix<Double> rotateZ3D(Double angle) {
        Matrix rotateMatrix = new Matrix<Double>(3, 3);

        rotateMatrix.set(0, 0, Math.cos(angle));
        rotateMatrix.set(0, 1, Math.sin(angle));
        rotateMatrix.set(0, 2, 0.0);

        rotateMatrix.set(1, 0, -Math.sin(angle));
        rotateMatrix.set(1, 1, Math.cos(angle));
        rotateMatrix.set(1, 2, 0.0);

        rotateMatrix.set(2, 0, 0.0);
        rotateMatrix.set(2, 1, 0.0);
        rotateMatrix.set(2, 2, 1.0);

        return rotateMatrix;
    }

    public static Matrix transferVectorTo3D(Matrix vector2D) {
        if (vector2D.width != 1 && vector2D.height != 2) {
            throw new RuntimeException("Only 2D vectors can be transfered to 3D");
        }

        Matrix result = new Matrix<Double>(1, 3);
        result.set(0, 0, vector2D.get(0, 0));
        result.set(0, 1, vector2D.get(0, 1));
        result.set(0, 2, 1.0);

        return result;
    }

    public static Matrix transferVectorTo2D(Matrix vector3D) {
        if (vector3D.width != 1 && vector3D.height != 3) {
            throw new RuntimeException("Only 3D vectors can be transfered to 2D");
        }

        Matrix result = new Matrix<Double>(1, 2);
        result.set(0, 0, vector3D.get(0, 0));
        result.set(0, 1, vector3D.get(0, 1));

        return result;
    }

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
        matrix = (T[][])new Object[width][height];
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
         matrix[x][y] = value;
    }

    /**
     * Returns the value for the specified position in the Matrix
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @return Value of the position
     */
    public T get(int x, int y) {
        return matrix[x][y];
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

    public String toString() {
        String output = "";
        
        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {
                output += String.format(" %03.2f ", (Double)get(x, y));
            }
            
            output += "\n";
        }

        return output;
    }

    public Matrix multiply(Matrix other) {
        if (width != other.getHeight()) {
            throw new RuntimeException("Matrix multiplication only possible if the left Matrix' width is equal to the right Matrix' height");
        }

        Matrix result = new Matrix<Double>(other.getWidth(), height);

   	for (int i = 0; i < height; i++) {
            for (int j = 0; j < other.getHeight() - 1; j++) {
                for (int k = 0; k < other.getHeight(); k++){

                    Double currentValue = (Double)result.get(j, i);

                    if (currentValue == null) {
                        currentValue = new Double(0);
                    }
                    
                    Double product = (Double)get(k, i) * (Double)other.get(j, k);
                    Double sum = currentValue + product;
                    result.set(j, i, sum);
                }
            }
        }

        return result;
    }

    public Matrix add(Matrix other) {
        if (width  != other.getWidth() ||
            height != other.getHeight()) {
            throw new RuntimeException("Matrix addition only works on two dimensional identical Matrices");
        }

        Matrix result = new Matrix<Double>(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                result.set(x, y, (Double)get(x, y) + (Double)other.get(x, y));
            }
        }

        return result;
    }
}
