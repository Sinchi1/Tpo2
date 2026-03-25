package org.truskovski.math.trigo;

import org.truskovski.math.MathFunction;

public class Sec implements MathFunction {

    private final MathFunction cos;

    public Sec(MathFunction cos) {
        this.cos = cos;
    }

    @Override
    public double compute(double x) {
        double c = cos.compute(x);

        if (Math.abs(c) < 1e-12) {
            return Double.POSITIVE_INFINITY;
        }

        return 1.0 / c;
    }
}
