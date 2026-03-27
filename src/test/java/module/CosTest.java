package module;

import org.junit.jupiter.api.BeforeEach;
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

    @ParameterizedTest
    @CsvSource({
            "0.0, 1.0",
            "3.141592653589793, -1.0",
            "1.5707963267948966, 0.0",
            "-1.5707963267948966, 0.0",
            "6.283185307179586, 1.0",
            "-3.141592653589793, -1.0",
            "1.0471975511965976, 0.5",
            "0.7853981633974483, 0.7071067811865476",
            "0.5235987755982988, 0.8660254037844386"
    })
    void testCosAbsolutes(double x, double expected) {
        assertEquals(expected, cos.compute(x), DELTA);
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

    @ParameterizedTest
    @ValueSource(doubles = {-10.0, -5.0, -1.0, 0.0, 1.0, 5.0, 10.0, 100.0})
    void testCosRange(double x) {
        double result = cos.compute(x);
        assertTrue(result >= -1.0 - DELTA && result <= 1.0 + DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-5.0, -2.7, -1.1, 0.3, 1.8, 3.4, 4.9})
    void testCosPeriodicity(double x) {
        assertEquals(cos.compute(x), cos.compute(x + 2 * Math.PI), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-20.0, -15.0, -10.0, 10.0, 15.0, 20.0, 50.0})
    void testCosLargeValues(double x) {
        assertEquals(Math.cos(x), cos.compute(x), 1e-4);
    }
}