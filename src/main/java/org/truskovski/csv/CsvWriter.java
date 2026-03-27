package org.truskovski.csv;

import org.truskovski.math.MathFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvWriter {

    public void write(String filename, MathFunction function,
                      double from, double to, double step) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("x,result");
            writer.newLine();

            for (double x = from; x <= to; x += step) {
                double result = function.compute(x);
                writer.write(x + "," + result);
                writer.newLine();
            }
        }
    }

}
