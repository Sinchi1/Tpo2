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

        when(cosMock.compute(x)).thenReturn(Math.cos(x));
        when(sinMock.compute(x)).thenReturn(Math.sin(x));

        Ctg ctg = new Ctg(cosMock, sinMock);

        assertEquals(expected, ctg.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0})
    void testCtgInfinity(double x) {

        when(cosMock.compute(x)).thenReturn(Math.cos(x));
        when(sinMock.compute(x)).thenReturn(0.0);

        Ctg ctg = new Ctg(cosMock, sinMock);

        assertTrue(Double.isInfinite(ctg.compute(x)));
    }
}