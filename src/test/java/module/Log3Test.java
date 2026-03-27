package module;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.truskovski.math.log.Log3;
import org.truskovski.math.log.Ln;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Log3Test {

    @Mock
    private Ln lnMock;

    private static final double DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "3.0, 1.0",
            "9.0, 2.0",
            "1.0, 0.0",
            "27.0, 3.0"
    })
    void testLog3(double x, double expected) {

        when(lnMock.compute(3.0)).thenReturn(1.0986122886681098);
        when(lnMock.compute(9.0)).thenReturn(2.1972245773362196);
        when(lnMock.compute(1.0)).thenReturn(0.0);
        when(lnMock.compute(27.0)).thenReturn(3.295836866004329);

        Log3 log3 = new Log3(lnMock);

        assertEquals(expected, log3.compute(x), DELTA);
    }
}