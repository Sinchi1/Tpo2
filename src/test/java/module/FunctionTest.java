package module;
import org.truskovski.math.Function;
import org.truskovski.math.trigo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class FunctionTest {

    @Test
    void testLogBranchAtTwo() {
        Function function = new Function();
        double x = 2.0;
        double result = function.compute(x);

        double lnX = Math.log(x);
        double log10X = Math.log10(x);
        double log3X = Math.log(x) / Math.log(3);
        double expected = (((log10X + lnX) / log3X + Math.pow(log3X, 2)) * (log3X / lnX)) / lnX;

        assertEquals(expected, result, 0.1);
    }

    @Test
    void testLogBranchAtFive() {
        Function function = new Function();
        double x = 5.0;
        double result = function.compute(x);

        double lnX = Math.log(x);
        double log10X = Math.log10(x);
        double log3X = Math.log(x) / Math.log(3);
        double expected = (((log10X + lnX) / log3X + Math.pow(log3X, 2)) * (log3X / lnX)) / lnX;

        assertEquals(expected, result, 0.1);
    }

    @Test
    void testLogBranchAtPointOne() {
        Function function = new Function();
        double x = 0.1;
        double result = function.compute(x);

        double lnX = Math.log(x);
        double log10X = Math.log10(x);
        double log3X = Math.log(x) / Math.log(3);
        double expected = (((log10X + lnX) / log3X + Math.pow(log3X, 2)) * (log3X / lnX)) / lnX;

        assertEquals(expected, result, 0.1);
    }
}
