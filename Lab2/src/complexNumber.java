
/**
 * Klasa reprezentująca wektor w przestrzeni zespolonej
 */
public class complexNumber extends Vector2D {

    public complexNumber(double x, double y) {
        super(x, y);
    }
    public double getModule() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }

    public double getArgument() {
        return Math.atan2(getY(), getX());
    }

    public complexNumber add(complexNumber other) {
        return new complexNumber(this.getX() + other.getX(), this.getY() + other.getY());
    }

    public complexNumber subtract(complexNumber other) {
        return new complexNumber(this.getX() - other.getX(), this.getY() - other.getY());
    }

    public complexNumber multiply(complexNumber other) {
        double realPart = this.getX() * other.getX() - this.getY() * other.getY();
        double imaginaryPart = this.getX() * other.getY() + this.getY() * other.getX();
        return new complexNumber(realPart, imaginaryPart);
    }

    public complexNumber divide(complexNumber other) {
        double denominator = other.getX() * other.getX() + other.getY() * other.getY();
        double realPart = (this.getX() * other.getX() + this.getY() * other.getY()) / denominator;
        double imaginaryPart = (this.getY() * other.getX() - this.getX() * other.getY()) / denominator;
        return new complexNumber(realPart, imaginaryPart);
    }





}
