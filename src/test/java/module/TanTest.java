package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Tan;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TanTest {

    @Mock private MathFunction cosMock;
    @Mock private MathFunction sinMock;

    private static final double DELTA = 1e-6;

    @Test
    void testTanZeroStub() {
        when(cosMock.compute(0.0)).thenReturn(1.0);
        when(sinMock.compute(0.0)).thenReturn(0.0);
        Tan tan = new Tan(cosMock, sinMock);
        assertEquals(0.0, tan.compute(0.0), DELTA);
    }

    @Test
    void testTanPiQuarterStub() {
        double x = Math.PI / 4;
        when(cosMock.compute(x)).thenReturn(Math.sqrt(2) / 2);
        when(sinMock.compute(x)).thenReturn(Math.sqrt(2) / 2);
        Tan tan = new Tan(cosMock, sinMock);
        assertEquals(1.0, tan.compute(x), DELTA);
    }

    @Test
    void testTanPiHalfStub() {
        double x = Math.PI / 2;
        when(cosMock.compute(x)).thenReturn(0.0);
        when(sinMock.compute(x)).thenReturn(1.0);
        Tan tan = new Tan(cosMock, sinMock);
        assertTrue(Double.isInfinite(tan.compute(x)));
    }
}
