package module;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log10;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Log10Test {

    @Mock private Ln lnMock;

    private static final double DELTA = 1e-6;

    @Test
    void testLog10TenWithStub() {
        when(lnMock.compute(10.0)).thenReturn(Math.log(10));
        Log10 log10 = new Log10(lnMock);
        assertEquals(1.0, log10.compute(10.0), DELTA);
    }

    @Test
    void testLog10OneWithStub() {
        when(lnMock.compute(10.0)).thenReturn(Math.log(10));
        when(lnMock.compute(1.0)).thenReturn(0.0);
        Log10 log10 = new Log10(lnMock);
        assertEquals(0.0, log10.compute(1.0), DELTA);
    }

    @Test
    void testLog10HundredWithStub() {
        when(lnMock.compute(10.0)).thenReturn(Math.log(10));
        when(lnMock.compute(100.0)).thenReturn(Math.log(100));
        Log10 log10 = new Log10(lnMock);
        assertEquals(2.0, log10.compute(100.0), DELTA);
    }

    @Test
    void testLog10TenthWithStub() {
        when(lnMock.compute(10.0)).thenReturn(Math.log(10));
        when(lnMock.compute(0.1)).thenReturn(Math.log(0.1));
        Log10 log10 = new Log10(lnMock);
        assertEquals(-1.0, log10.compute(0.1), DELTA);
    }
}
