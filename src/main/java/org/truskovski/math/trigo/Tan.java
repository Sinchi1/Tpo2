package org.truskovski.math.trigo;

import org.truskovski.math.MathFunction;

public class Tan implements MathFunction {

    private final MathFunction cos;
    private final MathFunction sin;

    public Tan(MathFunction cos, MathFunction sin) {
        this.cos = cos;
        this.sin = sin;
    }

    @Override
    public double compute(double x) {

        double s = sin.compute(x);
        double c = cos.compute(x);

        if (Math.abs(c) < 1e-12) {
            return Double.POSITIVE_INFINITY;
        }

        return s / c;
    }
}
