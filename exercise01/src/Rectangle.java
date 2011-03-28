
import name.aef.Matrix;

public class Rectangle {
    protected Matrix topLeft;
    protected Matrix topRight;
    protected Matrix bottomLeft;
    protected Matrix bottomRight;

    public Rectangle(Matrix topLeft, Matrix topRight, Matrix bottomLeft, Matrix bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public Matrix getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Matrix bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Matrix getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Matrix bottomRight) {
        this.bottomRight = bottomRight;
    }

    public Matrix getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Matrix topLeft) {
        this.topLeft = topLeft;
    }

    public Matrix getTopRight() {
        return topRight;
    }

    public void setTopRight(Matrix topRight) {
        this.topRight = topRight;
    }

    public Rectangle transform3D(Matrix transformationMatrix) {
        return new Rectangle(
            Matrix.transferVectorTo2D(transformationMatrix.multiply(Matrix.transferVectorTo3D(topLeft))),
            Matrix.transferVectorTo2D(transformationMatrix.multiply(Matrix.transferVectorTo3D(topRight))),
            Matrix.transferVectorTo2D(transformationMatrix.multiply(Matrix.transferVectorTo3D(bottomLeft))),
            Matrix.transferVectorTo2D(transformationMatrix.multiply(Matrix.transferVectorTo3D(bottomRight)))
        );
    }

    public Rectangle multiplicativeTransform2D(Matrix transformationMatrix) {
        return new Rectangle(
            transformationMatrix.multiply(topLeft),
            transformationMatrix.multiply(topRight),
            transformationMatrix.multiply(bottomLeft),
            transformationMatrix.multiply(bottomRight)
        );
    }

    public Rectangle additiveTransform2D(Matrix transformationVector) {
        return new Rectangle(
            transformationVector.add(topLeft),
            transformationVector.add(topRight),
            transformationVector.add(bottomLeft),
            transformationVector.add(bottomRight)
        );
    }

    public String toString() {
        String output = "";

        output += "Top left:\n" + topLeft + "\n";
        output += "Top right:\n" + topRight + "\n";
        output += "Bottom left:\n" + bottomLeft + "\n";
        output += "Bottom right:\n" + bottomRight + "\n";

        return output;
    }

}
