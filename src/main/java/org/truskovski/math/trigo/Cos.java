package org.truskovski.math.trigo;

import org.truskovski.math.MathFunction;

public class Cos  implements MathFunction {
    @Override
    public double compute(double x) {
        x = x % (2 * Math.PI);
        if (x > Math.PI)  x -= 2 * Math.PI;
        if (x < -Math.PI) x += 2 * Math.PI;

        double sum = 1.0;
        double term = 1.0;
        double x2 = x * x;
        int n = 1;

        while (n < 25) {
            term *= -x2 / (n * (n + 1));
            sum += term;
            n += 2;
        }

        return sum;
    }

}
