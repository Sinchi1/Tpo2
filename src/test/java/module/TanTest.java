package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Tan;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TanTest {

    @Mock
    private MathFunction cosMock;

    @Mock
    private MathFunction sinMock;

    private static final double DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "0.0, 0.0",
            "0.7853981633974483, 1.0"
    })
    void testTanValues(double x, double expected) {

        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.0) return 1.0;
                    if (arg == 0.7853981633974483) return 0.707106;

                    return 0.0;
                });

        when(sinMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.0) return 0.0;
                    if (arg == 0.7853981633974483) return 0.707106;

                    return 0.0;
                });

        Tan tan = new Tan(cosMock, sinMock);

        assertEquals(expected, tan.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.5707963267948966})
    void testTanInfinity(double x) {

        when(cosMock.compute(1.5707963267948966)).thenReturn(0.0);
        when(sinMock.compute(1.5707963267948966)).thenReturn(1.0);

        Tan tan = new Tan(cosMock, sinMock);

        assertTrue(Double.isInfinite(tan.compute(x)));
    }
}