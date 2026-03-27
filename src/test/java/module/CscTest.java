package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Csc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CscTest {

    @Mock
    private MathFunction sinMock;

    private static final double DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "1.5707963267948966, 1.0",
            "0.5235987755982988, 2.0"
    })
    void testCscValues(double x, double expected) {

        when(sinMock.compute(x)).thenReturn(Math.sin(x));

        Csc csc = new Csc(sinMock);

        assertEquals(expected, csc.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0})
    void testCscInfinity(double x) {

        when(sinMock.compute(x)).thenReturn(0.0);

        Csc csc = new Csc(sinMock);

        assertTrue(Double.isInfinite(csc.compute(x)));
    }
}