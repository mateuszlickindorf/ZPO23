import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {

    @Test
    public void testGetModule() {
        complexNumber complex = new complexNumber(3, 4);
        assertEquals(5.0, complex.getModule(), 1e-15);
    }

    @Test
    public void testGetArgument() {
        complexNumber complex = new complexNumber(-1, -1);
        assertEquals(-2.356194490192345, complex.getArgument(), 1e-15);
    }

    @Test
    public void testAdd() {
        complexNumber complex1 = new complexNumber(2, 3);
        complexNumber complex2 = new complexNumber(-1, 2);
        complexNumber result = complex1.add(complex2);
        assertEquals(1.0, result.getX(), 1e-15);
        assertEquals(5.0, result.getY(), 1e-15);
    }

    @Test
    public void testSubtract() {
        complexNumber complex1 = new complexNumber(5, 3);
        complexNumber complex2 = new complexNumber(-2, 1);
        complexNumber result = complex1.subtract(complex2);
        assertEquals(7.0, result.getX(), 1e-15);
        assertEquals(2.0, result.getY(), 1e-15);
    }

    @Test
    public void testMultiply() {
        complexNumber complex1 = new complexNumber(2, 1);
        complexNumber complex2 = new complexNumber(1, -3);
        complexNumber result = complex1.multiply(complex2);
        assertEquals(5.0, result.getX(), 1e-15);
        assertEquals(-5.0, result.getY(), 1e-15);
    }

    @Test
    public void testDivide() {
        complexNumber complex1 = new complexNumber(4, 3);
        complexNumber complex2 = new complexNumber(1, -2);
        complexNumber result = complex1.divide(complex2);

        double tolerance = 1e-1;
        assertEquals(0.5, result.getX(), tolerance);
        assertEquals(2.0, result.getY(), tolerance);
    }

    @Test
    public void testPower() {
        complexNumber complex = new complexNumber(2, 1);
        complexNumber result = complex.power(3);
        assertEquals(2.0000000000000018, result.getX(), 1e-15);
        assertEquals(11.000000000000002, result.getY(), 1e-15);
    }

    @Test
    public void testFromPolar() {
        complexNumber complex = complexNumber.fromPolar(2, Math.PI / 4);
        assertEquals(Math.sqrt(2), complex.getX(), 1e-15);
        assertEquals(Math.sqrt(2), complex.getY(), 1e-15);
    }

    @Test
    public void testToString() {
        complexNumber complex = new complexNumber(-3, 7);
        assertEquals("-3.0 + 7.0i", complex.toString());
    }

    @Test
    public void testEquals() {
        complexNumber complex1 = new complexNumber(1, 2);
        complexNumber complex2 = new complexNumber(1, 2);
        assertEquals(complex1, complex2);
    }

    @Test
    public void testHashCode() {
        complexNumber complex1 = new complexNumber(3, 4);
        complexNumber complex2 = new complexNumber(3, 4);
        assertEquals(complex1.hashCode(), complex2.hashCode());
    }

    @Test
    public void testInvalidInputException() {
        // Assuming the user enters an invalid complex number, the InvalidInputException should be thrown
        assertThrows(InvalidInputException.class, () -> {
            complexNumber.getComplexNumberFromUser();
        });
    }
}

