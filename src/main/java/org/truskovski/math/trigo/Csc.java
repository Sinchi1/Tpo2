package org.truskovski.math.trigo;

import org.truskovski.math.MathFunction;

public class Csc implements MathFunction {

    private final MathFunction sin;

    public Csc(MathFunction sin) {
        this.sin = sin;
    }

    @Override
    public double compute(double x) {
        double s = sin.compute(x);

        if (Math.abs(s) < 1e-12) {
            return Double.POSITIVE_INFINITY;
        }

        return 1.0 / s;
    }
}