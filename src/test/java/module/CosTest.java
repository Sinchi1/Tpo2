package module;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.truskovski.math.trigo.Cos;

import static org.junit.jupiter.api.Assertions.*;

class CosTest {

    private Cos cos;
    private static final double DELTA = 1e-4;

    @BeforeEach
    void setUp() {
        cos = new Cos();
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 1",
            "1.0, 0.540302",
            "3.14, -1",
            "4.7123, 0"
    })
    void testCosValues(double x, double expected) {
        assertEquals(expected, cos.compute(x), 1e-4);
    }

    @ParameterizedTest
    @CsvSource({
            "-10.0",
            "-5.0",
            "-1.0",
            "0.0",
            "5.0",
            "10.0"
    })
    void testCosRange(double x) {
        double result = cos.compute(x);
        assertTrue(result >= -1.0 - DELTA && result <= 1.0 + DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 0.540302",
            "-1.0, 0.540302",
            "3.14, -1.0",
            "-3.14, -1.0",
            "4.7123, 0.0",
            "-4.7123, 0.0"
    })
    void testCosPeriodicity(double x, double expected) {
        assertEquals(expected, cos.compute(x), DELTA);
    }
}