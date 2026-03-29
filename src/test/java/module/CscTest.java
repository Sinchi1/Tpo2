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
            "0.5235987755982988, 2.0",
            "0.7853981633974483, 1.4142135623730951",
            "1.0471975511965976, 1.1547005383792517",
            "1.5707963267948966, 1.0",
            "-0.5235987755982988, -2.0",
            "-0.7853981633974483, -1.4142135623730951",
            "-1.0471975511965976, -1.1547005383792517",
            "-1.5707963267948966, -1.0",
            "7.330382858376184, 1.1547005383792517",
            "-7.330382858376184, -1.1547005383792517"
    })
    void testCscValues(double x, double expected) {

        when(sinMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.5235987755982988) return 0.5;
                    if (arg == 0.7853981633974483) return 0.7071067811865476;
                    if (arg == 1.0471975511965976) return 0.8660254037844386;
                    if (arg == 1.5707963267948966) return 1.0;
                    if (arg == -0.5235987755982988) return -0.5;
                    if (arg == -0.7853981633974483) return -0.7071067811865476;
                    if (arg == -1.0471975511965976) return -0.8660254037844386;
                    if (arg == -1.5707963267948966) return -1.0;
                    if (arg == 7.330382858376184) return 0.8660254037844386;
                    if (arg == -7.330382858376184) return -0.8660254037844386;

                    return 0.0;
                });

        Csc csc = new Csc(sinMock);

        assertEquals(expected, csc.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            0.0,
            3.141592653589793,
            -3.141592653589793
    })
    void testCscInfinity(double x) {

        when(sinMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.0) return 0.0;
                    if (arg == 3.141592653589793) return 0.0;
                    if (arg == -3.141592653589793) return 0.0;

                    return 1.0;
                });

        Csc csc = new Csc(sinMock);

        assertTrue(Double.isInfinite(csc.compute(x)));
    }
}