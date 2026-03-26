package org.truskovski.csv;

import org.truskovski.math.MathFunction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvWriter {

    public void write(String filename, MathFunction function,
                      double from, double to, double step) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println("x,result");
            for (double x = from; x <= to; x += step) {
                double result = function.compute(x);
                out.println(x + ","+ result);
            }
        }
    }

}
