package module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Log3Test {

    @Mock private Ln lnMock;

    private static final double DELTA = 1e-6;

    @Test
    void testLog3ThreeWithStub() {
        when(lnMock.compute(3.0)).thenReturn(Math.log(3));
        Log3 log3 = new Log3(lnMock);
        assertEquals(1.0, log3.compute(3.0), DELTA);
    }

    @Test
    void testLog3NineWithStub() {
        when(lnMock.compute(3.0)).thenReturn(Math.log(3));
        when(lnMock.compute(9.0)).thenReturn(Math.log(9));
        Log3 log3 = new Log3(lnMock);
        assertEquals(2.0, log3.compute(9.0), DELTA);
    }

    @Test
    void testLog3OneWithStub() {
        when(lnMock.compute(3.0)).thenReturn(Math.log(3));
        when(lnMock.compute(1.0)).thenReturn(0.0);
        Log3 log3 = new Log3(lnMock);
        assertEquals(0.0, log3.compute(1.0), DELTA);
    }

    @Test
    void testLog3TwentySevenWithStub() {
        when(lnMock.compute(3.0)).thenReturn(Math.log(3));
        when(lnMock.compute(27.0)).thenReturn(Math.log(27));
        Log3 log3 = new Log3(lnMock);
        assertEquals(3.0, log3.compute(27.0), DELTA);
    }
}
