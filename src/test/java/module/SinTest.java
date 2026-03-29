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
            "0.5235987755982988, 0.5",
            "0.7853981633974483, 0.7071067811865476",
            "1.0471975511965976, 0.8660254037844386",
            "1.5707963267948966, 1.0",
            "2.0943951023931953, 0.8660254037844386",
            "2.356194490192345, 0.7071067811865476",
            "2.6179938779914944, 0.5",
            "3.141592653589793, 0.0",
            "-0.5235987755982988, -0.5",
            "-0.7853981633974483, -0.7071067811865476",
            "-1.0471975511965976, -0.8660254037844386",
            "-1.5707963267948966, -1.0",
            "8.377580409572781, 0.8660254037844386"
    })
    void testSinValues(double x, double expected) {

        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.0) return 1.0;
                    if (arg == 0.5235987755982988) return 0.8660254037844386;
                    if (arg == 0.7853981633974483) return 0.7071067811865476;
                    if (arg == 1.0471975511965976) return 0.5;
                    if (arg == 1.5707963267948966) return 0.0;
                    if (arg == 2.0943951023931953) return -0.5;
                    if (arg == 2.356194490192345) return -0.7071067811865476;
                    if (arg == 2.6179938779914944) return -0.8660254037844386;
                    if (arg == 3.141592653589793) return -1.0;
                    if (arg == -0.5235987755982988) return 0.8660254037844386;
                    if (arg == -0.7853981633974483) return 0.7071067811865476;
                    if (arg == -1.0471975511965976) return 0.5;
                    if (arg == -1.5707963267948966) return 0.0;
                    if (arg == 8.377580409572781) return -0.5;

                    return 0.0;
                });

        Sin sin = new Sin(cosMock);

        assertEquals(expected, sin.compute(x), DELTA);
    }
}