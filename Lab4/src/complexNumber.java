import java.util.Objects;
import java.util.Scanner;

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
     * @param other The complex number to add to this one.
     * @return The result of the addition.
     */
    public complexNumber add(complexNumber other) {
        return new complexNumber(this.getX() + other.getX(), this.getY() + other.getY());
    }

    /**
     * Subtracts one complex number from another.
     *
     * @param other The complex number to subtract from this one.
     * @return The result of the subtraction.
     */
    public complexNumber subtract(complexNumber other) {
        return new complexNumber(this.getX() - other.getX(), this.getY() - other.getY());
    }

    /**
     * Multiplies two complex numbers.
     *
     * @param other The complex number to multiply with this one.
     * @return The result of the multiplication.
     */
    public complexNumber multiply(complexNumber other) {
        double realPart = this.getX() * other.getX() - this.getY() * other.getY();
        double imaginaryPart = this.getX() * other.getY() + this.getY() * other.getX();
        return new complexNumber(realPart, imaginaryPart);
    }

    /**
     * Divides this complex number by another complex number.
     *
     * @param other The complex number to divide this one by.
     * @return The result of the division.
     * @throws ArithmeticException if the divisor is zero.
     */
    public complexNumber divide(complexNumber other) {
        double denominator = other.getX() * other.getX() + other.getY() * other.getY();
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        double realPart = (this.getX() * other.getX() + this.getY() * other.getY()) / denominator;
        double imaginaryPart = (this.getY() * other.getX() - this.getX() * other.getY()) / denominator;
        return new complexNumber(realPart, imaginaryPart);
    }

    /**
     * Calculates the nth power of the complex number.
     *
     * @param n The exponent for the power operation.
     * @return The complex number raised to the power of n.
     */
    public complexNumber power(int n) {
        double module = getModule();
        double argument = getArgument();
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

    /**
     * Retrieves a complex number from the user in the form x+iy or other valid variations.
     *
     * @return The complex number entered by the user.
     * @throws InvalidInputException if the input format is incorrect.
     */
    public static complexNumber getComplexNumberFromUser() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a complex number in the form x+iy or other valid variations:");
        String input = scanner.nextLine();

        // Use a regular expression to validate and extract real and imaginary parts
        String regex = "([-+]?\\d*\\.?\\d+)\\s*([-+]?)\\s*([-+]?\\d*\\.?\\d*)i";
        if (input.matches(regex)) {
            double realPart = Double.parseDouble(input.replaceAll(regex, "$1"));
            double imaginaryPart = Double.parseDouble(input.replaceAll(regex, "$2$3"));
            return new complexNumber(realPart, imaginaryPart);
        } else {
            throw new InvalidInputException("Invalid input format. Please enter a valid complex number.", input);
        }
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


