package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Sec;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SecTest {

    @Mock
    private MathFunction cosMock;

    private static final double DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "0.0, 1.0",
            "3.141592653589793, -1.0",
            "1.0471975511965976, 2.0"
    })
    void testSecValues(double x, double expected) {

        when(cosMock.compute(0.0)).thenReturn(1.0);
        when(cosMock.compute(3.141592653589793)).thenReturn(-1.0);
        when(cosMock.compute(1.0471975511965976)).thenReturn(0.5);

        Sec sec = new Sec(cosMock);

        assertEquals(expected, sec.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.5707963267948966})
    void testSecInfinity(double x) {

        when(cosMock.compute(1.5707963267948966)).thenReturn(0.0);

        Sec sec = new Sec(cosMock);

        assertTrue(Double.isInfinite(sec.compute(x)));
    }
}