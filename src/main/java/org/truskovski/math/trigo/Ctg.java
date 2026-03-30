package org.truskovski.math.trigo;

import org.truskovski.math.MathFunction;

public class Ctg  implements MathFunction {

    private final MathFunction cos;
    private final MathFunction sin;

    public Ctg(MathFunction cos, MathFunction sin) {
        this.cos = cos;
        this.sin = sin;
    }

    @Override
    public double compute(double x) {

        double s = sin.compute(x);
        double c = cos.compute(x);

        if (x % Math.PI == 0.0) {
            return Double.POSITIVE_INFINITY;
        }

        return c / s;
    }
}
