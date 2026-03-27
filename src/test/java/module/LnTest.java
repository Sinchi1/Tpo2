package module;

import org.junit.jupiter.api.BeforeEach;
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

    @ParameterizedTest
    @CsvSource({
            "1.0, 0.0",
            "2.718281828459045, 1.0",
            "7.3890560989306495, 2.0",
            "0.36787944117144233, -1.0"
    })
    void testLnSpecialValues(double x, double expected) {
        assertEquals(expected, ln.compute(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.1, -2.302585",
            "0.5, -0.693147",
            "2.0, 0.693147",
            "3.0, 1.098612"
    })
    void testLnTableValues(double x, double expected) {
        assertEquals(expected, ln.compute(x), 1e-4);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.0})
    void testLnInvalidArguments(double x) {
        assertThrows(IllegalArgumentException.class, () -> ln.compute(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.5, 1.5, 2.0, 5.0, 10.0})
    void testLnVsMathLog(double x) {
        assertEquals(Math.log(x), ln.compute(x), 1e-5);
    }

    @ParameterizedTest
    @CsvSource({
            "2.5, 4.0",
            "1.2, 3.7",
            "5.0, 0.8"
    })
    void testLnProductProperty(double a, double b) {
        assertEquals(ln.compute(a) + ln.compute(b), ln.compute(a * b), 1e-5);
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 3.0",
            "5.5, 2.2",
            "8.0, 0.5"
    })
    void testLnQuotientProperty(double a, double b) {
        assertEquals(ln.compute(a) - ln.compute(b), ln.compute(a / b), 1e-5);
    }
}