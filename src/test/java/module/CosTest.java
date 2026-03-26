package module;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.truskovski.math.trigo.Cos;

import static org.junit.jupiter.api.Assertions.*;

class CosTest {

    private Cos cos;
    private static final double DELTA = 1e-6;

    @BeforeEach
    void setUp() {
        cos = new Cos();
    }

    @Test
    void testCosZero() {
        assertEquals(1.0, cos.compute(0), DELTA);
    }

    @Test
    void testCosPi() {
        assertEquals(-1.0, cos.compute(Math.PI), DELTA);
    }

    @Test
    void testCosPiHalf() {
        assertEquals(0.0, cos.compute(Math.PI / 2), DELTA);
    }

    @Test
    void testCosMinusPiHalf() {
        assertEquals(0.0, cos.compute(-Math.PI / 2), DELTA);
    }

    @Test
    void testCosTwoPi() {
        assertEquals(1.0, cos.compute(2 * Math.PI), DELTA);
    }

    @Test
    void testCosMinusPi() {
        assertEquals(-1.0, cos.compute(-Math.PI), DELTA);
    }

    @Test
    void testCosPiThird() {
        assertEquals(0.5, cos.compute(Math.PI / 3), DELTA);
    }

    @Test
    void testCosPiQuarter() {
        assertEquals(Math.sqrt(2) / 2, cos.compute(Math.PI / 4), DELTA);
    }

    @Test
    void testCosPiSixth() {
        assertEquals(Math.sqrt(3) / 2, cos.compute(Math.PI / 6), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.5, 0.877583",
            "1.0, 0.540302",
            "1.5, 0.070737",
            "2.0, -0.416147",
            "3.0, -0.989992",
            "-1.0, 0.540302",
            "-2.0, -0.416147",
            "-3.0, -0.989992",
            "-5.5, 0.708670"
    })
    void testCosValues(double x, double expected) {
        assertEquals(expected, cos.compute(x), 1e-4);
    }

    @Test
    void testCosEven() {
        for (double x = 0.1; x < 6; x += 0.5) {
            assertEquals(cos.compute(x), cos.compute(-x), DELTA);
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10.0, -5.0, -1.0, 0.0, 1.0, 5.0, 10.0, 100.0})
    void testCosRange(double x) {
        double result = cos.compute(x);
        assertTrue(result >= -1.0 - DELTA && result <= 1.0 + DELTA);
    }

    @Test
    void testCosPeriodicity() {
        for (double x = -5; x <= 5; x += 0.3) {
            assertEquals(cos.compute(x), cos.compute(x + 2 * Math.PI), DELTA);
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {-20.0, -15.0, -10.0, 10.0, 15.0, 20.0, 50.0})
    void testCosLargeValues(double x) {
        assertEquals(Math.cos(x), cos.compute(x), 1e-4);
    }
}
