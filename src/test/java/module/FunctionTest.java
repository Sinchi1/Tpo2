package module;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.truskovski.math.Function;
import org.truskovski.math.trigo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class FunctionTest {

    @ParameterizedTest
    @ValueSource(doubles = {2.0, 0.1, 5.0,})
    void testLogBranch(double x) {
        Function function = new Function();
        double result = function.compute(x);

        double lnX = Math.log(x);
        double log10X = Math.log10(x);
        double log3X = Math.log(x) / Math.log(3);
        double expected = (((log10X + lnX) / log3X + Math.pow(log3X, 2)) * (log3X / lnX)) / lnX;

        assertEquals(expected, result, 0.1);
    }
}
