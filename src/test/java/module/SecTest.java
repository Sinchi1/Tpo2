package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Sec;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SecTest {

    @Mock private MathFunction cosMock;

    @Test
    void testSecZeroStub() {
        when(cosMock.compute(0.0)).thenReturn(1.0);
        Sec sec = new Sec(cosMock);
        assertEquals(1.0, sec.compute(0.0), 1e-6);
    }

    @Test
    void testSecPiStub() {
        when(cosMock.compute(Math.PI)).thenReturn(-1.0);
        Sec sec = new Sec(cosMock);
        assertEquals(-1.0, sec.compute(Math.PI), 1e-6);
    }

    @Test
    void testSecPiHalfStub() {
        when(cosMock.compute(Math.PI / 2)).thenReturn(0.0);
        Sec sec = new Sec(cosMock);
        assertTrue(Double.isInfinite(sec.compute(Math.PI / 2)));
    }

    @Test
    void testSecPiThirdStub() {
        when(cosMock.compute(Math.PI / 3)).thenReturn(0.5);
        Sec sec = new Sec(cosMock);
        assertEquals(2.0, sec.compute(Math.PI / 3), 1e-6);
    }
}
