package org.truskovski.math.log;

import org.truskovski.math.MathFunction;

public class Ln implements MathFunction {

    @Override
    public double compute(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("ln(x) определён только для x > 0");
        }

        double y = (x - 1.0) / (x + 1.0);
        double y2 = y * y;
        double sum = 0.0;
        double term = y;
        int k = 1;

        while (k < 100) {
            sum += term / k;
            term *= y2;
            k += 2;
            if (Math.abs(term) < 1e-14){
                break;
            }
        }

        return 2.0 * sum;
    }
}