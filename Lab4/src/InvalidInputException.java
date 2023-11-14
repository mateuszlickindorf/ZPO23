/**
 * Custom exception class to handle invalid input from the user when entering a complex number.
 */
public class InvalidInputException extends Exception {
    private String input;

    /**
     * Constructs an InvalidInputException with a specific error message and the invalid input.
     *
     * @param message The error message describing the nature of the invalid input.
     * @param input   The invalid input provided by the user.
     */
    public InvalidInputException(String message, String input) {
        super(message);
        this.input = input;
    }

    /**
     * Gets the invalid input that caused the exception.
     *
     * @return The invalid input provided by the user.
     */
    public String getInput() {
        return input;
    }
    /**
     * Provides a string representation of the exception, including the error message and invalid input.
     *
     * @return A string representation of the InvalidInputException.
     */
    @Override
    public String toString() {
        return "InvalidInputException{" +
                "message='" + getMessage() + '\'' +
                ", input='" + input + '\'' +
                '}';
    }
}
