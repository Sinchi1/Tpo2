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
            "0.5235987755982988, 1.1547005383792517",
            "0.7853981633974483, 1.4142135623730951",
            "1.0471975511965976, 2.0",
            "2.0943951023931953, -2.0",
            "2.356194490192345, -1.4142135623730951",
            "2.6179938779914944, -1.1547005383792517",
            "3.141592653589793, -1.0",
            "-0.5235987755982988, 1.1547005383792517",
            "-0.7853981633974483, 1.4142135623730951",
            "-1.0471975511965976, 2.0",
            "-2.0943951023931953, -2.0",
            "-3.141592653589793, -1.0",
            "6.283185307179586, 1.0",
            "8.377580409572781, -2.0"
    })
    void testSecValues(double x, double expected) {

        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.0) return 1.0;
                    if (arg == 0.5235987755982988) return 0.8660254037844386;
                    if (arg == 0.7853981633974483) return 0.7071067811865476;
                    if (arg == 1.0471975511965976) return 0.5;
                    if (arg == 2.0943951023931953) return -0.5;
                    if (arg == 2.356194490192345) return -0.7071067811865476;
                    if (arg == 2.6179938779914944) return -0.8660254037844386;
                    if (arg == 3.141592653589793) return -1.0;
                    if (arg == -0.5235987755982988) return 0.8660254037844386;
                    if (arg == -0.7853981633974483) return 0.7071067811865476;
                    if (arg == -1.0471975511965976) return 0.5;
                    if (arg == -2.0943951023931953) return -0.5;
                    if (arg == -3.141592653589793) return -1.0;
                    if (arg == 6.283185307179586) return 1.0;
                    if (arg == 8.377580409572781) return -0.5;

                    return 0.0;
                });

        Sec sec = new Sec(cosMock);

        assertEquals(expected, sec.compute(x), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            1.5707963267948966,
            -1.5707963267948966,
            7.853981633974483
    })
    void testSecInfinity(double x) {

        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 1.5707963267948966) return 0.0;
                    if (arg == -1.5707963267948966) return 0.0;
                    if (arg == 7.853981633974483) return 0.0;

                    return 1.0;
                });

        Sec sec = new Sec(cosMock);

        assertTrue(Double.isInfinite(sec.compute(x)));
    }
}