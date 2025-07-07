package botty;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals("1 + 1 should equal 2", 2, calculator.add(1, 1));
    }

    @Test
    public void testSubtraction() {
        assertEquals("5 - 3 should equal 2", 2, calculator.subtract(5, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals("2 * 3 should equal 6", 6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals("10 / 2 should equal 5", 5, calculator.divide(10, 2));
    }
}
