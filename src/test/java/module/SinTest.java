package module;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.MathFunction;
import org.truskovski.math.trigo.Sin;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SinTest {

    @Mock
    private MathFunction cosMock;

    private static final double DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "0.0, 0.0",
            "1.5707963267948966, 1.0",
            "3.141592653589793, 0.0",
            "-1.5707963267948966, -1.0",
            "0.5235987755982988, 0.5"
    })
    void testSinValues(double x, double expected) {

        when(cosMock.compute(x)).thenReturn(Math.cos(x));

        Sin sin = new Sin(cosMock);

        assertEquals(expected, sin.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -2.3, -0.7})
    void testSinNegative(double x) {

        when(cosMock.compute(x)).thenReturn(Math.cos(x));

        Sin sin = new Sin(cosMock);

        double result = sin.compute(x);

        assertTrue(result < 0);
        assertEquals(Math.sin(x), result, 1e-4);
    }
}