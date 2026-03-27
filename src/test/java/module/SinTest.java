package module;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.MathFunction;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.truskovski.math.trigo.Sin;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SinTest {

    @Mock
    private MathFunction cosMock;

    private static final double DELTA = 1e-6;

    @Test
    void testSinZeroWithStub() {
        when(cosMock.compute(0.0)).thenReturn(1.0);
        Sin sin = new Sin(cosMock);
        assertEquals(0.0, sin.compute(0.0), DELTA);
    }

    @Test
    void testSinPiHalfWithStub() {
        when(cosMock.compute(Math.PI / 2)).thenReturn(0.0);
        Sin sin = new Sin(cosMock);
        assertEquals(1.0, sin.compute(Math.PI / 2), DELTA);
    }

    @Test
    void testSinPiWithStub() {
        when(cosMock.compute(Math.PI)).thenReturn(-1.0);
        Sin sin = new Sin(cosMock);
        assertEquals(0.0, sin.compute(Math.PI), DELTA);
    }

    @Test
    void testSinMinusPiHalfWithStub() {
        when(cosMock.compute(-Math.PI / 2)).thenReturn(0.0);
        Sin sin = new Sin(cosMock);
        assertEquals(-1.0, sin.compute(-Math.PI / 2), DELTA);
    }

    @Test
    void testSinPiSixthWithStub() {
        when(cosMock.compute(Math.PI / 6)).thenReturn(Math.sqrt(3) / 2);
        Sin sin = new Sin(cosMock);
        assertEquals(0.5, sin.compute(Math.PI / 6), DELTA);
    }

    @Test
    void testSinNegativeWithStub() {
        when(cosMock.compute(-1.0)).thenReturn(Math.cos(-1.0));
        Sin sin = new Sin(cosMock);
        double result = sin.compute(-1.0);
        assertTrue(result < 0);
        assertEquals(Math.sin(-1.0), result, 1e-4);
    }
}
