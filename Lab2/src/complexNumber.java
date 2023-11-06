import java.util.Objects;

/**
 * Represents a complex number with real and imaginary parts.
 */
public class complexNumber extends Vector2D {

    /**
     * Constructs a complex number with the specified real and imaginary parts.
     *
     * @param x The real part.
     * @param y The imaginary part.
     */
    public complexNumber(double x, double y) {
        super(x, y);
    }

    /**
     * Gets the modulus (absolute value) of the complex number.
     *
     * @return The modulus of the complex number.
     */
    public double getModule() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }

    /**
     * Gets the argument (angle) of the complex number in radians.
     *
     * @return The argument of the complex number.
     */
    public double getArgument() {
        return Math.atan2(getY(), getX());
    }

    /**
     * Adds two complex numbers.
     *
     * @param a First complex number.
     * @param b Second complex number.
     * @return The result of the addition.
     */
    public static complexNumber add(complexNumber a, complexNumber b) {
        return new complexNumber(a.getX() + b.getX(), a.getY() + b.getY());
    }

    /**
     * Subtracts one complex number from another.
     *
     * @param a First complex number.
     * @param b Second complex number that will be substracted from the first.
     * @return The result of the subtraction.
     */
    public static complexNumber subtract(complexNumber a, complexNumber b) {
        return new complexNumber(a.getX() - b.getX(), a.getY() - b.getY());
    }

    /**
     * Multiplies two complex numbers.
     *
     * @param a First complex number.
     * @param b Second complex number which will be multiplied by the first.
     * @return The result of the multiplication.
     */
    public static complexNumber multiply(complexNumber a, complexNumber b) {
        double realPart = a.getX() * b.getX() - a.getY() * b.getY();
        double imaginaryPart = a.getX() * b.getY() + a.getY() * b.getX();
        return new complexNumber(realPart, imaginaryPart);
    }

    /**
     * Divides this complex number by another complex number.
     *
     * @param a First complex number that will be divided by the second number.
     * @param b Second complex number.
     * @return The result of the division.
     * @throws ArithmeticException if the divisor is zero.
     */
    public static complexNumber divide(complexNumber a, complexNumber b) {
        double denominator = b.getX() * b.getX() + b.getY() * b.getY();
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        double realPart = (a.getX() * b.getX() + a.getY() * b.getY()) / denominator;
        double imaginaryPart = (a.getY() * b.getX() - a.getX() * b.getY()) / denominator;
        return new complexNumber(realPart, imaginaryPart);
    }

    /**
     * Calculates the nth power of the complex number.
     *
     * @param n The exponent for the power operation.
     * @param z The complex mumber which will raised to the power of n.
     * @return The complex number raised to the power of n.
     */
    public static complexNumber power(complexNumber z, int n) {
        double module = z.getModule();
        double argument = z.getArgument();
        double resultModule = Math.pow(module, n);
        double resultArgument = argument * n;
        double realPart = resultModule * Math.cos(resultArgument);
        double imaginaryPart = resultModule * Math.sin(resultArgument);
        return new complexNumber(realPart, imaginaryPart);
    }

    /**
     * Creates a complex number from polar coordinates.
     *
     * @param module   The modulus of the complex number.
     * @param argument The argument of the complex number in radians.
     * @return A complex number created from polar coordinates.
     */
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


