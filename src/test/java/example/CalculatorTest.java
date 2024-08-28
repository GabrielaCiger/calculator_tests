package example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Addition test")
    void addition() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    @DisplayName("Subtract test")
    void subtract() {
        assertEquals(8, calculator.subtract(10, 2));
    }

    @Test
    @DisplayName("Multiply test")
    void multiply() {
        assertEquals(20, calculator.multiply(10, 2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    @DisplayName("Divide test")
    void divide(int number) {
        assertEquals(1, calculator.divide(number, 8));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    @DisplayName("Divide test 2")
    void divideTrue(int number) {
        if (number==0){
            ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
                calculator.divide(8, number);
            });
            assertEquals("Cannot divide by zero", thrown.getMessage());
        } else {
            float result = calculator.divide(8, number);
            assertTrue(result >= 1);
        }
    }
}
