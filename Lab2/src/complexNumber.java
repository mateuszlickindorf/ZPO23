import java.util.Objects;

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

    public complexNumber power(int n) {
        double module = getModule();
        double argument = getArgument();
        double resultModule = Math.pow(module, n);
        double resultArgument = argument * n;
        double realPart = resultModule * Math.cos(resultArgument);
        double imaginaryPart = resultModule * Math.sin(resultArgument);
        return new complexNumber(realPart, imaginaryPart);
    }

    public static complexNumber fromPolar(double module, double argument) {
        double realPart = module * Math.cos(argument);
        double imaginaryPart = module * Math.sin(argument);
        return new complexNumber(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return getX() + " + " + getY() + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        complexNumber other = (complexNumber) obj;
        return Double.compare(other.getX(), getX()) == 0 && Double.compare(other.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}


