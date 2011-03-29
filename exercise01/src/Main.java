import name.aef.Rectangle;
import name.aef.*;

public class Main {
    public static void main(String args[]) {
        complex3DTests();
    }

    public static void complex3DTests() {
        Rectangle rectangle = new Rectangle(
            Matrix.verticalVector(new Double[]{2.0, 2.0}), // Top left
            Matrix.verticalVector(new Double[]{4.0, 2.0}), // Top right
            Matrix.verticalVector(new Double[]{4.0, 4.0}), // Bottom left
            Matrix.verticalVector(new Double[]{2.0, 4.0})  // Bottom right
        );

        System.out.println("Original rectangle:\n" + rectangle + "\n");

        Matrix translation = Matrix.translate2Don3D(3.0, 3.0);
        Matrix rotation    = Matrix.rotateZ3D(Math.toRadians(45));

        System.out.println("Transformation Matrix:\n" + rotation);
//        Rectangle result = rectangle.transform3D(rotation);
//        result = rectangle.transform3D(rotation);
//        System.out.println("Result rectangle:\n" + result + "\n");
    }

    public static void simple2DTests() {
        Rectangle rectangle = new Rectangle(
            Matrix.verticalVector(new Double[]{0.0, 1.0}),
            Matrix.verticalVector(new Double[]{1.0, 1.0}),
            Matrix.verticalVector(new Double[]{0.0, 0.0}),
            Matrix.verticalVector(new Double[]{0.0, 1.0})
        );
        
        System.out.println("Original rectangle:\n" + rectangle + "\n");

        translateTest(rectangle);
        scaleTest(rectangle);
        rotateTest(rectangle);
    }

    public static void translateTest(Rectangle rectangle) {
        Matrix translationVector = Matrix.translate2D(5.0, 0.0);
        
        Rectangle scaledRectangle = rectangle.additiveTransform2D(translationVector);
        System.out.println("Translated rectangle:\n" + scaledRectangle + "\n");
    }

    public static void rotateTest(Rectangle rectangle) {
        double degree = 90;

        Matrix rotationMatrix = Matrix.rotate2D(Math.toRadians(degree));

        Rectangle scaledRectangle = rectangle.multiplicativeTransform2D(rotationMatrix);
        System.out.println("" + degree + "° rotated rectangle:\n" + scaledRectangle + "\n");
    }

    public static void scaleTest(Rectangle rectangle) {
        Matrix scaleMatrix = Matrix.scale2D(2.0, 2.0);

        Rectangle scaledRectangle = rectangle.multiplicativeTransform2D(scaleMatrix);
        System.out.println("Scaled rectangle:\n" + scaledRectangle + "\n");
    }
}
