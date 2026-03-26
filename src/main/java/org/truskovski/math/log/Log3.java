package org.truskovski.math.log;

import org.truskovski.math.MathFunction;

public class Log3 implements MathFunction {

    private final Ln ln;

    public Log3(Ln ln) {
        this.ln = ln;
    }

    public double ln(double x) {
        return ln.compute(x);
    }

    @Override
    public double compute(double x) {
        if (x <= 0) throw new IllegalArgumentException("log3(x) только для x > 0");
        return ln(x) / ln(3.0);
    }
}
