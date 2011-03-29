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
public class RectangleTest {

    public RectangleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testTranslate2D() {
        Rectangle rectangle = new Rectangle(
            Matrix.verticalVector(new Double[]{0.0, 1.0}),
            Matrix.verticalVector(new Double[]{1.0, 1.0}),
            Matrix.verticalVector(new Double[]{0.0, 0.0}),
            Matrix.verticalVector(new Double[]{0.0, 1.0})
        );

        Matrix translationVector = Matrix.translate2D(5.0, -2.0);

        Rectangle scaledRectangle = rectangle.additiveTransform2D(translationVector);

        assertEquals(new Double(5.0),  (Double)scaledRectangle.getTopLeft().get(0, 0));
        assertEquals(new Double(-1.0), (Double)scaledRectangle.getTopLeft().get(0, 1));
        assertEquals(new Double(6.0),  (Double)scaledRectangle.getTopRight().get(0, 0));
        assertEquals(new Double(-1.0), (Double)scaledRectangle.getTopRight().get(0, 1));
        assertEquals(new Double(5.0),  (Double)scaledRectangle.getBottomLeft().get(0, 0));
        assertEquals(new Double(-2.0), (Double)scaledRectangle.getBottomLeft().get(0, 1));
        assertEquals(new Double(5.0),  (Double)scaledRectangle.getBottomRight().get(0, 0));
        assertEquals(new Double(-1.0), (Double)scaledRectangle.getBottomRight().get(0, 1));
    }

//    @Test
//    public static void testRotate2D() {
//        Rectangle rectangle = new Rectangle(
//            Matrix.verticalVector(new Double[]{0.0, 1.0}),
//            Matrix.verticalVector(new Double[]{1.0, 1.0}),
//            Matrix.verticalVector(new Double[]{0.0, 0.0}),
//            Matrix.verticalVector(new Double[]{0.0, 1.0})
//        );
//
//        double degree = 90;
//
//        Matrix rotationMatrix = Matrix.rotate2D(Math.toRadians(degree));
//
//        Rectangle scaledRectangle = rectangle.multiplicativeTransform2D(rotationMatrix);
//        System.out.println("" + degree + "° rotated rectangle:\n" + scaledRectangle + "\n");
//    }

//    @Test
//    public static void testScale2D() {
//        Rectangle rectangle = new Rectangle(
//            Matrix.verticalVector(new Double[]{0.0, 1.0}),
//            Matrix.verticalVector(new Double[]{1.0, 1.0}),
//            Matrix.verticalVector(new Double[]{0.0, 0.0}),
//            Matrix.verticalVector(new Double[]{0.0, 1.0})
//        );
//
//        Matrix scaleMatrix = Matrix.scale2D(2.0, 2.0);
//
//        Rectangle scaledRectangle = rectangle.multiplicativeTransform2D(scaleMatrix);
//        System.out.println("Scaled rectangle:\n" + scaledRectangle + "\n");
//    }

}