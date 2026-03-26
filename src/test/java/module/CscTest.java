package module;

import org.truskovski.math.MathFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.trigo.Csc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CscTest {

    @Mock private MathFunction sinMock;

    @Test
    void testCscPiHalfStub() {
        when(sinMock.compute(Math.PI / 2)).thenReturn(1.0);
        Csc csc = new Csc(sinMock);
        assertEquals(1.0, csc.compute(Math.PI / 2), 1e-6);
    }

    @Test
    void testCscPiSixthStub() {
        when(sinMock.compute(Math.PI / 6)).thenReturn(0.5);
        Csc csc = new Csc(sinMock);
        assertEquals(2.0, csc.compute(Math.PI / 6), 1e-6);
    }

    @Test
    void testCscZeroStub() {
        when(sinMock.compute(0.0)).thenReturn(0.0);
        Csc csc = new Csc(sinMock);
        assertTrue(Double.isInfinite(csc.compute(0.0)));
    }
}
