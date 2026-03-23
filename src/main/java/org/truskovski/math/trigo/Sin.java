package org.truskovski.math.trigo;

import org.truskovski.math.MathFunction;

public class Sin implements MathFunction {

    private final MathFunction cos;

    public Sin(MathFunction cos) {
        this.cos = cos;
    }

    @Override
    public double compute(double x) {
        double cosRes = cos.compute(x);
        double sinRes = Math.sqrt(1 - Math.pow(cosRes, 2));

        x = x % (2 * Math.PI);
        if (x > Math.PI)  x -= 2 * Math.PI;
        if (x < -Math.PI) x += 2 * Math.PI;

        return x < 0 ? -sinRes : sinRes;
    }
}
