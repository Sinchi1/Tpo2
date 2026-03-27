package inter;

import org.junit.jupiter.api.Test;
import org.truskovski.math.Function;
import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log10;
import org.truskovski.math.log.Log3;
import org.truskovski.math.trigo.*;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationalTest {

    private static final double D = 1e-3;

    @Test
    void sinCos() {
        Cos cos = new Cos(); Sin sin = new Sin(cos);
        for (double x = -5; x <= 5; x += 0.7)
            assertEquals(1.0, sin.compute(x)*sin.compute(x) + cos.compute(x)*cos.compute(x), D);
    }

    @Test
    void sec() {
        Cos cos = new Cos(); Sec sec = new Sec(cos);
        for (double x = 0.2; x < 1.4; x += 0.3)
            assertEquals(1.0, sec.compute(x) * cos.compute(x), D);
    }

    @Test
    void csc() {
        Cos cos = new Cos(); Sin sin = new Sin(cos); Csc csc = new Csc(sin);
        for (double x = 0.2; x < 3; x += 0.5)
            assertEquals(1.0, csc.compute(x) * sin.compute(x), D);
    }

    @Test
    void tanCtg() {
        Cos cos = new Cos(); Sin sin = new Sin(cos);
        Tan tan = new Tan(cos, sin); Ctg ctg = new Ctg(cos, sin);
        for (double x = 0.2; x < 1.4; x += 0.3)
            assertEquals(1.0, tan.compute(x) * ctg.compute(x), D);
    }

    @Test
    void tanSec() {
        Cos cos = new Cos(); Sin sin = new Sin(cos);
        Tan tan = new Tan(cos, sin); Sec sec = new Sec(cos);
        for (double x = -1.2; x < 1.2; x += 0.3) {
            double t = tan.compute(x), s = sec.compute(x);
            assertEquals(s * s, 1 + t * t, D);
        }
    }

    @Test
    void log10() {
        Ln ln = new Ln();
        Log10 log10 = new Log10(ln);
        assertEquals(0.0, log10.compute(1), D);
        assertEquals(1.0, log10.compute(10), D);
    }

    @Test
    void log3() {
        Ln ln = new Ln();
        Log3 log3 = new Log3(ln);
        assertEquals(0.0, log3.compute(1), D);
        assertEquals(1.0, log3.compute(3), D);
        assertEquals(2.0, log3.compute(9), D);
        assertEquals(3.0, log3.compute(27), D);
    }


    @Test
    void functionTrigBranch() {
        Function f = new Function();
        for (double x : new double[]{-0.5, -1, -2, -4, -5})
            assertDoesNotThrow(() -> f.compute(x));
    }
}
