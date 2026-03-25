package org.truskovski.math.log;

public class LogFunctions {

    private final Ln ln;

    public LogFunctions() {
        this.ln = new Ln();
    }

    public double ln(double x) {
        return ln.compute(x);
    }

    public double log10(double x) {
        if (x <= 0) throw new IllegalArgumentException("log10(x) только для x > 0");
        return ln(x) / ln(10.0);
    }

    public double log3(double x) {
        if (x <= 0) throw new IllegalArgumentException("log3(x) только для x > 0");
        return ln(x) / ln(3.0);
    }
}