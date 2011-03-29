/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package name.aef;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ppu2
 */
public class MatrixTest {

    public MatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testVerticalVector() {
        Matrix vector = Matrix.verticalVector(new Double[]{7.0, 3.5, 4.0});

        assertEquals(1, vector.getWidth());
        assertEquals(3, vector.getHeight());
        assertEquals(new Double(7.0), (Double)vector.get(0, 0));
        assertEquals(new Double(3.5), (Double)vector.get(0, 1));
        assertEquals(new Double(4.0), (Double)vector.get(0, 2));
    }

    @Test
    public void testMatrixMultiplication() {
        Matrix left  = new Matrix<Double>(2, 2);
        left.set(0, 0, 1.0);
        left.set(0, 1, 1.5);
        left.set(1, 0, 2.0);
        left.set(1, 1, 3.0);
        
        System.out.format("Left matrix (Width: %d; Height: %d):\n", left.getWidth(), left.getHeight());
        System.out.println(left);

        Matrix right = Matrix.verticalVector(new Double[]{5.5, 2.0});
        
        System.out.format("Right matrix (Width: %d; Height: %d):\n", right.getWidth(), right.getHeight());
        System.out.println(right);

        Matrix result = left.multiply(right);

        System.out.format("Result matrix (Width: %d; Height: %d):\n", result.getWidth(), result.getHeight());
        System.out.println(result);

     
        assertEquals(new Double(9.5),   (Double)result.get(0, 0));
        assertEquals(new Double(14.25), (Double)result.get(0, 1));
    }

    @Test
    public void testVectorTo3D() {
        Matrix vector2D = new Matrix<Double>(1, 2);
        vector2D.set(0, 0, 5.5);
        vector2D.set(0, 1, 2.0);

        Matrix vector3D = Matrix.transferVectorTo3D(vector2D);
        assertEquals(3, vector3D.getHeight());
        assertEquals(1, vector3D.getWidth());
        assertEquals(new Double(5.5), vector3D.get(0, 0));
        assertEquals(new Double(2.0), vector3D.get(0, 1));
        assertEquals(new Double(1.0), vector3D.get(0, 2));
    }

    @Test
    public void testVectorTo2D() {
        Matrix vector3D = new Matrix<Double>(1, 3);
        vector3D.set(0, 0, 5.5);
        vector3D.set(0, 1, 2.0);
        vector3D.set(0, 2, 1.0);

        Matrix vector2D = Matrix.transferVectorTo2D(vector3D);
        assertEquals(2, vector2D.getHeight());
        assertEquals(1, vector2D.getWidth());
        assertEquals(new Double(5.5), vector2D.get(0, 0));
        assertEquals(new Double(2.0), vector2D.get(0, 1));
    }

    @Test
    public void testMatrixMultiplicationBig() {
        Matrix translation = new Matrix<Double>(3, 3);

        translation.set(0, 0, 1.0);
        translation.set(0, 1, 0.0);
        translation.set(0, 2, 0.0);

        translation.set(1, 0, 0.0);
        translation.set(1, 1, 1.0);
        translation.set(1, 2, 0.0);

        translation.set(2, 0, 3.0);
        translation.set(2, 1, 3.0);
        translation.set(2, 2, 1.0);

        Matrix rotation = new Matrix<Double>(3, 3);

        translation.set(0, 0, 0.71);
        translation.set(0, 1, 0.71);
        translation.set(0, 2, 0.0);

        translation.set(1, 0, -0.71);
        translation.set(1, 1, 0.71);
        translation.set(1, 2, 0.0);

        translation.set(2, 0, 0.0);
        translation.set(2, 1, 0.0);
        translation.set(2, 2, 1.0);

        Matrix result = translation.multiply(rotation);

        assertEquals(new Double(0.71), result.get(0, 0));
        assertEquals(new Double(0.71), result.get(0, 1));
        assertEquals(new Double(0.0), result.get(0, 2));

        assertEquals(new Double(-0.71), result.get(1, 0));
        assertEquals(new Double(0.71), result.get(1, 1));
        assertEquals(new Double(0.0), result.get(1, 2));

        assertEquals(new Double(3.0), result.get(2, 0));
        assertEquals(new Double(3.0), result.get(2, 1));
        assertEquals(new Double(1.0), result.get(2, 2));
    }


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}