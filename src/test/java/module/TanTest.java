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
            "0.5235987755982988, 0.5773502691896257",
            "0.7853981633974483, 1.0",
            "1.0471975511965976, 1.7320508075688772",
            "-0.5235987755982988, -0.5773502691896257",
            "-0.7853981633974483, -1.0",
            "-1.0471975511965976, -1.7320508075688772"
    })
    void testTanValues(double x, double expected) {

        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.0) return 1.0;
                    if (arg == 0.5235987755982988) return 0.8660254037844386;
                    if (arg == 0.7853981633974483) return 0.7071067811865476;
                    if (arg == 1.0471975511965976) return 0.5;
                    if (arg == -0.5235987755982988) return 0.8660254037844386;
                    if (arg == -0.7853981633974483) return 0.7071067811865476;
                    if (arg == -1.0471975511965976) return 0.5;

                    return 0.0;
                });

        when(sinMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 0.0) return 0.0;
                    if (arg == 0.5235987755982988) return 0.5;
                    if (arg == 0.7853981633974483) return 0.7071067811865476;
                    if (arg == 1.0471975511965976) return 0.8660254037844386;
                    if (arg == -0.5235987755982988) return -0.5;
                    if (arg == -0.7853981633974483) return -0.7071067811865476;
                    if (arg == -1.0471975511965976) return -0.8660254037844386;

                    return 0.0;
                });

        Tan tan = new Tan(cosMock, sinMock);

        assertEquals(expected, tan.compute(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "1.5707963267948966",
            "-1.5707963267948966"
    })
    void testTanInfinity(double x) {

        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 1.5707963267948966) return 0.0;
                    if (arg == -1.5707963267948966) return 0.0;

                    return 0.0;
                });

        when(sinMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 1.5707963267948966) return 1.0;
                    if (arg == -1.5707963267948966) return -1.0;

                    return 0.0;
                });

        Tan tan = new Tan(cosMock, sinMock);

        assertTrue(Double.isInfinite(tan.compute(x)));
    }

    @ParameterizedTest
    @CsvSource({
            "7.330382858376184, 1.7320508075688772",
            "-7.330382858376184, -1.7320508075688772"
    })
    void testTanPeriod(double x, double expected) {

        when(cosMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 7.330382858376184) return 0.5;
                    if (arg == -7.330382858376184) return 0.5;

                    return 0.0;
                });

        when(sinMock.compute(x))
                .thenAnswer(invocation -> {
                    double arg = invocation.getArgument(0);

                    if (arg == 7.330382858376184) return 0.8660254037844386;
                    if (arg == -7.330382858376184) return -0.8660254037844386;

                    return 0.0;
                });

        Tan tan = new Tan(cosMock, sinMock);

        assertEquals(expected, tan.compute(x), DELTA);
    }
}