package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Ctg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CtgTest {

    @Mock private MathFunction cosMock;
    @Mock private MathFunction sinMock;

    private static final double DELTA = 1e-6;

    @Test
    void testCtgPiQuarterStub() {
        double x = Math.PI / 4;
        when(cosMock.compute(x)).thenReturn(Math.sqrt(2) / 2);
        when(sinMock.compute(x)).thenReturn(Math.sqrt(2) / 2);
        Ctg ctg = new Ctg(cosMock, sinMock);
        assertEquals(1.0, ctg.compute(x), DELTA);
    }

    @Test
    void testCtgPiHalfStub() {
        double x = Math.PI / 2;
        when(cosMock.compute(x)).thenReturn(0.0);
        when(sinMock.compute(x)).thenReturn(1.0);
        Ctg ctg = new Ctg(cosMock, sinMock);
        assertEquals(0.0, ctg.compute(x), DELTA);
    }

    @Test
    void testCtgZeroStub() {
        when(cosMock.compute(0.0)).thenReturn(1.0);
        when(sinMock.compute(0.0)).thenReturn(0.0);
        Ctg ctg = new Ctg(cosMock, sinMock);
        assertTrue(Double.isInfinite(ctg.compute(0.0)));
    }
}
