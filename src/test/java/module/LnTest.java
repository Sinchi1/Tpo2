package module;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.truskovski.math.log.Ln;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {

    private Ln ln;
    private static final double DELTA = 1e-6;

    @BeforeEach
    void setUp() {
        ln = new Ln();
    }

    @Test
    void testLnOne() {
        assertEquals(0.0, ln.compute(1.0), DELTA);
    }

    @Test
    void testLnE() {
        assertEquals(1.0, ln.compute(Math.E), DELTA);
    }

    @Test
    void testLnESquared() {
        assertEquals(2.0, ln.compute(Math.E * Math.E), DELTA);
    }

    @Test
    void testLnOneOverE() {
        assertEquals(-1.0, ln.compute(1.0 / Math.E), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.001, -6.907755",
            "0.01, -4.605170",
            "0.1, -2.302585",
            "0.5, -0.693147",
            "2.0, 0.693147",
            "3.0, 1.098612",
            "10.0, 2.302585",
            "100.0, 4.605170",
            "1000.0, 6.907755"
    })
    void testLnValues(double x, double expected) {
        assertEquals(expected, ln.compute(x), 1e-4);
    }

    @Test
    void testLnZero() {
        assertThrows(IllegalArgumentException.class, () -> ln.compute(0));
    }

    @Test
    void testLnNegative() {
        assertThrows(IllegalArgumentException.class, () -> ln.compute(-1));
    }

    @Test
    void testLnLargeNegative() {
        assertThrows(IllegalArgumentException.class, () -> ln.compute(-100));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.001, 0.01, 0.1, 0.5, 1.5, 2, 5, 10, 50, 100, 1000})
    void testLnVsMathLog(double x) {
        assertEquals(Math.log(x), ln.compute(x), 1e-5);
    }

    @Test
    void testLnProduct() {
        double a = 2.5, b = 4.0;
        assertEquals(ln.compute(a) + ln.compute(b), ln.compute(a * b), 1e-5);
    }

    @Test
    void testLnQuotient() {
        double a = 10.0, b = 3.0;
        assertEquals(ln.compute(a) - ln.compute(b), ln.compute(a / b), 1e-5);
    }

    @Test
    void testLnPower() {
        double a = 2.0;
        int n = 5;
        assertEquals(n * ln.compute(a), ln.compute(Math.pow(a, n)), 1e-4);
    }

    @Test
    void testLnNearZero() {
        assertTrue(ln.compute(1e-10) < -20);
        assertTrue(ln.compute(1e-5) < -10);
    }
}
