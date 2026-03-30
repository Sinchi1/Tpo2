package inter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.truskovski.csv.CsvWriter;
import org.truskovski.math.Function;
import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log10;
import org.truskovski.math.log.Log3;
import org.truskovski.math.trigo.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IntegrationalTest {

    private static final double DELTA = 1e-4;

    @Mock
    Cos cosMock;

    @Mock
    Ln lnMock;

    @Mock
    Sin sinMock;
    @Mock
    Tan  tanMock;
    @Mock
    Csc cscMock;
    @Mock
    Sec secMock;
    @Mock
    Ctg ctgMock;
    @Mock
    Log3 log3Mock;
    @Mock
    Log10 log10Mock;

    @ParameterizedTest
    @MockitoSettings(strictness = Strictness.LENIENT)
    @CsvSource({
            "-0.39713, -0.000526",
            "-0.50266, 0",
            "-1.5708, 0",
            "-1.73553, 0.000719",
            "-2.356125, 0",
            "-2.80184, -0.000004",
            "-3.65636, 0.01746",
            "-3.80062, 0",
            "-5.61377, 0.000004",
            "-5.3471, -0.000001",
            "-5.26365, -0.000001",
            "-5.4977825, 0",
    })
    void testLvl1(double x, double expected) {

        when(cosMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return 0.92106;
            if (arg == -0.50266) return 0.87630;
            if (arg == -1.5708)  return -3.6732051033918982E-6;
            if (arg == -1.73553) return -0.16398;
            if (arg == -2.356125)return -0.70711;
            if (arg == -2.80184) return -0.93969;
            if (arg == -3.65636) return -0.87036;
            if (arg == -3.80062) return -0.79100;
            if (arg == -5.61377) return 0.78100;
            if (arg == -5.3471)  return 0.60100;
            if (arg == -5.26365) return 0.52300;
            if (arg == -5.4977825)return 0.70711;
            if (arg == -5.87329) return -0.91500;

            return 1.0;
        });

        when(sinMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return -0.38942;
            if (arg == -0.50266) return -0.48176;
            if (arg == -1.5708)  return -0.9999999999932537;
            if (arg == -1.73553) return -0.98646;
            if (arg == -2.356125)return -0.70711;
            if (arg == -2.80184) return -0.34202;
            if (arg == -3.65636) return 0.49300;
            if (arg == -3.80062) return 0.61100;
            if (arg == -5.61377) return 0.62300;
            if (arg == -5.3471)  return 0.79900;
            if (arg == -5.26365) return 0.85200;
            if (arg == -5.4977825)return 0.70711;
            if (arg == -5.87329) return 0.40300;

            return 0.0;
        });

        when(tanMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return -0.4230;
            if (arg == -0.50266) return -0.5498;
            if (arg == -1.5708)  return 272241.808405917;
            if (arg == -1.73553) return 6.015393486807044;
            if (arg == -2.356125)return 1.000;
            if (arg == -2.80184) return 0.3640;
            if (arg == -3.65636) return -0.567;
            if (arg == -3.80062) return -0.772;
            if (arg == -5.61377) return 0.797;
            if (arg == -5.3471)  return 1.327;
            if (arg == -5.26365) return 1.628;
            if (arg == -5.4977825)return 1.000;
            if (arg == -5.87329) return 0.440;

            return 0.0;
        });

        when(secMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return 1.0857;
            if (arg == -0.50266) return 1.1412;
            if (arg == -1.5708)  return -272241.80840775365;
            if (arg == -1.73553) return -6.097947097271392;
            if (arg == -2.356125)return -1.4142;
            if (arg == -2.80184) return -1.0642;
            if (arg == -3.65636) return -1.149;
            if (arg == -3.80062) return -1.265;
            if (arg == -5.61377) return 1.278;
            if (arg == -5.3471)  return 1.661;
            if (arg == -5.26365) return 1.912;
            if (arg == -5.4977825)return 1.4142;
            if (arg == -5.87329) return 1.093;

            return 0.0;
        });

        when(ctgMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return -2.364;
            if (arg == -0.50266) return -1.819;
            if (arg == -1.5708)  return 3.6732051034166786E-6;
            if (arg == -1.73553) return 0.16624016403801334;
            if (arg == -2.356125)return 1.000;
            if (arg == -2.80184) return 2.747;
            if (arg == -3.65636) return -1.764;
            if (arg == -3.80062) return -1.298;
            if (arg == -5.61377) return 1.276;
            if (arg == -5.3471)  return 0.751;
            if (arg == -5.26365) return 0.621;
            if (arg == -5.4977825)return 1.000;
            if (arg == -5.87329) return 2.274;

            return 0.0;
        });

        when(cscMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return -2.568;
            if (arg == -0.50266) return -2.076;
            if (arg == -1.5708)  return -1.0000000000067464;
            if (arg == -1.73553) return -1.0137237257455236;
            if (arg == -2.356125)return -1.4142;
            if (arg == -2.80184) return -2.924;
            if (arg == -3.65636) return 2.03;
            if (arg == -3.80062) return 1.635;
            if (arg == -5.61377) return 1.607;
            if (arg == -5.3471)  return 1.251;
            if (arg == -5.26365) return 1.174;
            if (arg == -5.4977825)return 1.4142;
            if (arg == -5.87329) return 2.479;

            return 0.0;
        });

        when(lnMock.compute(anyDouble())).thenReturn(0.0);

        when(log3Mock.compute(anyDouble())).thenReturn(0.0);

        when(log10Mock.compute(anyDouble())).thenReturn(0.0);

        Function f = new Function(cosMock, sinMock, secMock, tanMock, cscMock, ctgMock, lnMock, log3Mock, log10Mock);

        assertEquals(expected, f.compute(x), DELTA);
    }

    @ParameterizedTest
    @MockitoSettings(strictness = Strictness.LENIENT)
    @CsvSource({
            "-0.39713, -0.000526",
            "-0.50266, 0",
            "-1.5708, 0",
            "-1.73553, 0.000719",
            "-2.356125, 0",
            "-2.80184, -0.000004",
            "-3.65636, 0.01746",
            "-3.80062, 0",
            "-5.61377, 0.000004",
            "-5.3471, -0.000001",
            "-5.26365, -0.000001",
            "-5.4977825, 0",
    })
    void testLvl2(double x, double expected) {

        when(cosMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return 0.92106;
            if (arg == -0.50266) return 0.87630;
            if (arg == -1.5708)  return -3.6732051033918982E-6;
            if (arg == -1.73553) return -0.16398;
            if (arg == -2.356125)return -0.70711;
            if (arg == -2.80184) return -0.93969;
            if (arg == -3.65636) return -0.87036;
            if (arg == -3.80062) return -0.79100;
            if (arg == -5.61377) return 0.78100;
            if (arg == -5.3471)  return 0.60100;
            if (arg == -5.26365) return 0.52300;
            if (arg == -5.4977825)return 0.70711;
            if (arg == -5.87329) return -0.91500;

            return 1.0;
        });

        when(sinMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return -0.38942;
            if (arg == -0.50266) return -0.48176;
            if (arg == -1.5708)  return -0.9999999999932537;
            if (arg == -1.73553) return -0.98646;
            if (arg == -2.356125)return -0.70711;
            if (arg == -2.80184) return -0.34202;
            if (arg == -3.65636) return 0.49300;
            if (arg == -3.80062) return 0.61100;
            if (arg == -5.61377) return 0.62300;
            if (arg == -5.3471)  return 0.79900;
            if (arg == -5.26365) return 0.85200;
            if (arg == -5.4977825)return 0.70711;
            if (arg == -5.87329) return 0.40300;

            return 0.0;
        });

        when(secMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return 1.0857;
            if (arg == -0.50266) return 1.1412;
            if (arg == -1.5708)  return -272241.80840775365;
            if (arg == -1.73553) return -6.097947097271392;
            if (arg == -2.356125)return -1.4142;
            if (arg == -2.80184) return -1.0642;
            if (arg == -3.65636) return -1.149;
            if (arg == -3.80062) return -1.265;
            if (arg == -5.61377) return 1.278;
            if (arg == -5.3471)  return 1.661;
            if (arg == -5.26365) return 1.912;
            if (arg == -5.4977825)return 1.4142;
            if (arg == -5.87329) return 1.093;

            return 0.0;
        });


        when(lnMock.compute(anyDouble())).thenReturn(0.0);

        Function f = new Function(cosMock, sinMock, secMock, new Tan(cosMock, sinMock),
                new Csc(sinMock), new Ctg(cosMock, sinMock), lnMock, new Log3(lnMock), new Log10(lnMock));

        assertEquals(expected, f.compute(x), DELTA);
    }


    @ParameterizedTest
    @MockitoSettings(strictness = Strictness.LENIENT)
    @CsvSource({
            "-0.39713, -0.000526",
            "-0.50266, 0",
            "-1.5708, 0",
            "-1.73553, 0.000719",
            "-2.356125, 0",
            "-2.80184, -0.000004",
            "-3.65636, 0.01746",
            "-3.80062, 0",
            "-5.61377, 0.000004",
            "-5.3471, -0.000001",
            "-5.26365, -0.000001",
            "-5.4977825, 0",
    })
    void testLvl3(double x, double expected) {

        when(cosMock.compute(anyDouble())).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);

            if (arg == -0.39713) return 0.92106;
            if (arg == -0.50266) return 0.87630;
            if (arg == -1.5708)  return -3.6732051033918982E-6;
            if (arg == -1.73553) return -0.16398;
            if (arg == -2.356125)return -0.70711;
            if (arg == -2.80184) return -0.93969;
            if (arg == -3.65636) return -0.87036;
            if (arg == -3.80062) return -0.79100;
            if (arg == -5.61377) return 0.78100;
            if (arg == -5.3471)  return 0.60100;
            if (arg == -5.26365) return 0.52300;
            if (arg == -5.4977825)return 0.70711;
            if (arg == -5.87329) return -0.91500;

            return 1.0;
        });

        var sin = new Sin(cosMock);
        var ln = new Ln();

        Function f = new Function(cosMock, sin, new Sec(cosMock), new Tan(cosMock, sin),
                new Csc(sin), new Ctg(cosMock, sin), ln, new Log3(ln), new Log10(ln));

        assertEquals(expected, f.compute(x), DELTA);
    }

    @ParameterizedTest
    @MockitoSettings(strictness = Strictness.LENIENT)
    @CsvSource({
            "-0.39713, -0.000526",
            "-0.50266, 0",
            "-1.5708, 0",
            "-1.73553, 0.000719",
            "-2.356125, 0",
            "-2.80184, -0.000004",
            "-3.65636, 0.01746",
            "-3.80062, 0",
            "-5.61377, 0.000004",
            "-5.3471, -0.000001",
            "-5.26365, -0.000001",
            "-5.4977825, 0",
    })
    void testLvl4(double x, double expected) {

        var cos = new Cos();
        var ln = new Ln();

        var sin = new Sin(cos);
        var tan = new Tan(cos, sin);
        var sec = new Sec(cos);
        var ctg = new Ctg(cos, sin);
        var csc = new Csc(sin);

        var log3 = new Log3(ln);
        var log10 = new Log10(ln);

        Function f = new Function(cos, sin, sec, tan, csc, ctg, ln, log3, log10);


        assertEquals(expected, f.compute(x), DELTA);
    }
}