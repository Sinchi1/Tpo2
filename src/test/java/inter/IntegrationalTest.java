package inter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.truskovski.math.Function;
import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log10;
import org.truskovski.math.log.Log3;
import org.truskovski.math.trigo.*;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationalTest {

    private static final double D = 1e-3;

    @ParameterizedTest
    @ValueSource(doubles = {-5.0, -4.3, -2.2, -1.5, -0.8, -0.1, 3.4, 4.1, 4.8, 5.0})
    void sinCosProperty(double x) {
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        assertEquals(1.0, sin.compute(x) * sin.compute(x) + cos.compute(x) * cos.compute(x), D);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.5, 0.8, 1.1})
    void secProperty(double x) {
        Cos cos = new Cos();
        Sec sec = new Sec(cos);
        assertEquals(1.0, sec.compute(x) * cos.compute(x), D);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.7, 1.2, 1.7, 2.2, 2.7})
    void cscProperty(double x) {
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        Csc csc = new Csc(sin);
        assertEquals(1.0, csc.compute(x) * sin.compute(x), D);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.5, 0.8, 1.1})
    void tanCtgProperty(double x) {
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        Tan tan = new Tan(cos, sin);
        Ctg ctg = new Ctg(cos, sin);
        assertEquals(1.0, tan.compute(x) * ctg.compute(x), D);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.2, -0.9, -0.6, -0.3, 0.0, 0.3, 0.6, 0.9})
    void tanSecIdentity(double x) {
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        Tan tan = new Tan(cos, sin);
        Sec sec = new Sec(cos);
        double t = tan.compute(x);
        double s = sec.compute(x);
        assertEquals(s * s, 1 + t * t, D);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0.0",
            "10, 1.0"
    })
    void log10Values(double x, double expected) {
        Ln ln = new Ln();
        Log10 log10 = new Log10(ln);
        assertEquals(expected, log10.compute(x), D);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0.0",
            "3, 1.0",
            "9, 2.0",
            "27, 3.0"
    })
    void log3Values(double x, double expected) {
        Ln ln = new Ln();
        Log3 log3 = new Log3(ln);
        assertEquals(expected, log3.compute(x), D);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.5, -1, -2, -4, -5})
    void functionTrigBranchDoesNotThrow(double x) {
        Function f = new Function();
        assertDoesNotThrow(() -> f.compute(x));
    }
}