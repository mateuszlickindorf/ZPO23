import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * Represents a complex number with real and imaginary parts.
 */
public class complexNumberExtended extends Vector2DExtended {

    /**
     * Constructs a complex number with the specified real and imaginary parts.
     *
     * @param x The real part.
     * @param y The imaginary part.
     */
    public complexNumberExtended(double x, double y) {
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
    public complexNumberExtended add(complexNumberExtended other) {
        return new complexNumberExtended(this.getX() + other.getX(), this.getY() + other.getY());
    }

    /**
     * Subtracts one complex number from another.
     *
     * @param other The complex number to subtract from this one.
     * @return The result of the subtraction.
     */
    public complexNumberExtended subtract(complexNumberExtended other) {
        return new complexNumberExtended(this.getX() - other.getX(), this.getY() - other.getY());
    }

    /**
     * Multiplies two complex numbers.
     *
     * @param other The complex number to multiply with this one.
     * @return The result of the multiplication.
     */
    public complexNumberExtended multiply(complexNumberExtended other) {
        double realPart = this.getX() * other.getX() - this.getY() * other.getY();
        double imaginaryPart = this.getX() * other.getY() + this.getY() * other.getX();
        return new complexNumberExtended(realPart, imaginaryPart);
    }

    /**
     * Divides this complex number by another complex number.
     *
     * @param other The complex number to divide this one by.
     * @return The result of the division.
     * @throws ArithmeticException if the divisor is zero.
     */
    public complexNumberExtended divide(complexNumberExtended other) {
        double denominator = other.getX() * other.getX() + other.getY() * other.getY();
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        double realPart = (this.getX() * other.getX() + this.getY() * other.getY()) / denominator;
        double imaginaryPart = (this.getY() * other.getX() - this.getX() * other.getY()) / denominator;
        return new complexNumberExtended(realPart, imaginaryPart);
    }

    /**
     * Calculates the nth power of the complex number.
     *
     * @param n The exponent for the power operation.
     * @return The complex number raised to the power of n.
     */
    public complexNumberExtended power(int n) {
        double module = getModule();
        double argument = getArgument();
        double resultModule = Math.pow(module, n);
        double resultArgument = argument * n;
        double realPart = resultModule * Math.cos(resultArgument);
        double imaginaryPart = resultModule * Math.sin(resultArgument);
        return new complexNumberExtended(realPart, imaginaryPart);
    }

    /**
     * Creates a complex number from polar coordinates.
     *
     * @param module   The modulus of the complex number.
     * @param argument The argument of the complex number in radians.
     * @return A complex number created from polar coordinates.
     */
    public static complexNumberExtended fromPolar(double module, double argument) {
        double realPart = module * Math.cos(argument);
        double imaginaryPart = module * Math.sin(argument);
        return new complexNumberExtended(realPart, imaginaryPart);
    }

    /**
     * Retrieves a complex number from the user in the form x+iy or other valid variations.
     *
     * @return The complex number entered by the user.
     * @throws InvalidInputException if the input format is incorrect.
     */
    public static complexNumberExtended getComplexNumberFromUser() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a complex number in the form x+iy or other valid variations:");
        String input = scanner.nextLine();

        // Regular expression to validate and extract real and imaginary parts
        String regex = "([-+]?\\d*\\.?\\d+)\\s*([-+]?)\\s*([-+]?\\d*\\.?\\d*)i";
        if (input.matches(regex)) {
            double realPart = Double.parseDouble(input.replaceAll(regex, "$1"));
            double imaginaryPart = Double.parseDouble(input.replaceAll(regex, "$2$3"));
            return new complexNumberExtended(realPart, imaginaryPart);
        } else {
            throw new InvalidInputException("Invalid input format. Please enter a valid complex number.", input);
        }
    }

    /**
     * Reads data from a file containing complex numbers and calculates modulus and argument.
     *
     * @param fileName The name of the file to read.
     * @throws IOException if an I/O error occurs.
     */
    public static void readComplexData(String fileName) throws IOException {

        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("# t mod arg");
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) continue; // Skip comments

                String[] parts = line.split("\\s+");
                double t = Double.parseDouble(parts[0]);

                String complexNumberPart = parts[1];
                String[] realImagParts = complexNumberPart.split("(?=[+-])", 2);
                if (realImagParts.length > 1) {
                    realImagParts[1] = realImagParts[1].replaceAll("i", "");
                }
                double x = Double.parseDouble(realImagParts[0]);
                double y = Double.parseDouble(realImagParts[1]);


                complexNumberExtended complexNumber = new complexNumberExtended(x, y);
                double modulus = complexNumber.getModule();
                double argument = complexNumber.getArgument();

                System.out.printf("%f %f %f%n", t, modulus, argument);
            }
        }
    }

    /**
     * Writes data to an output file in the specified format.
     *
     * @param inputFileName  The name of the input file.
     * @param outputFileName The name of the output file.
     * @param append         True if data should be appended to an existing file.
     * @throws IOException if an I/O error occurs.
     */
    public static void writeComplexData(String inputFileName, String outputFileName, boolean append) throws IOException {

        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Input file not found: " + inputFileName);
        }

        File outputFile = new File(outputFileName);
        if (outputFileName == null || outputFileName.isEmpty()) {
            //default output file name if not specified
            outputFile = new File("out_data.out");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName, append))) {
            if (!append) {
                writer.write("# t mod arg\n");
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty() || line.startsWith("#")) {
                        continue;
                    }
                    String[] parts = line.split("\\s+");
                    double t = Double.parseDouble(parts[0]);

                    String complexNumberPart = parts[1];
                    String[] realImagParts = complexNumberPart.split("(?=[+-])", 2);
                    if (realImagParts.length > 1) {
                        realImagParts[1] = realImagParts[1].replaceAll("i", "");
                    }
                    double x = Double.parseDouble(realImagParts[0]);
                    double y = Double.parseDouble(realImagParts[1]);

                    complexNumberExtended complexNumber = new complexNumberExtended(x, y);
                    double modulus = complexNumber.getModule();
                    double argument = complexNumber.getArgument();

                    writer.write(String.format("%f %f %f%n", t, modulus, argument));
                }
            }
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
        complexNumberExtended other = (complexNumberExtended) obj;
        return Double.compare(other.getX(), getX()) == 0 && Double.compare(other.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

}


