package module;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Log10Test {

    @Mock
    private Ln lnMock;

    private static final double DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "10.0, 1.0",
            "1.0, 0.0",
            "100.0, 2.0",
            "0.1, -1.0"
    })
    void testLog10(double x, double expected) {

        when(lnMock.compute(10.0)).thenReturn(2.302585092994046);
        when(lnMock.compute(1.0)).thenReturn(0.0);
        when(lnMock.compute(100.0)).thenReturn(4.605170185988092);
        when(lnMock.compute(0.1)).thenReturn(-2.302585092994046);

        Log10 log10 = new Log10(lnMock);

        assertEquals(expected, log10.compute(x), DELTA);
    }
}