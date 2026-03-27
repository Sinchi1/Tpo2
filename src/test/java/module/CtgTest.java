package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Ctg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CtgTest {

    @Mock
    private MathFunction cosMock;

    @Mock
    private MathFunction sinMock;

    private static final double DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "0.7853981633974483, 1.0",
            "1.5707963267948966, 0.0"
    })
    void testCtgValues(double x, double expected) {

        when(sinMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.7853981633974483) return 0.707106;
                    if (arg == 1.5707963267948966) return 1.0;

                    return 0.0;
                });


        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.7853981633974483) return 0.707106;
                    if (arg == 1.5707963267948966) return 0.0;

                    return 0.0;
                });

        Ctg ctg = new Ctg(cosMock, sinMock);

        assertEquals(expected, ctg.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0})
    void testCtgInfinity(double x) {

        when(cosMock.compute(0.0)).thenReturn(1.0);
        when(sinMock.compute(0.0)).thenReturn(0.0);

        Ctg ctg = new Ctg(cosMock, sinMock);

        assertTrue(Double.isInfinite(ctg.compute(x)));
    }
}