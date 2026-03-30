package org.truskovski;

import org.truskovski.csv.CsvWriter;
import org.truskovski.math.Function;
import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log10;
import org.truskovski.math.log.Log3;
import org.truskovski.math.trigo.*;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        var cos = new Cos();
        var ln = new Ln();

        var sin = new Sin(cos);
        var tan = new Tan(cos, sin);
        var sec = new Sec(cos);
        var ctg = new Ctg(cos, sin);
        var csc = new Csc(sin);

        var log3 = new Log3(ln);
        var log10 = new Log10(ln);

        var writer =  new CsvWriter();

        Function function = new Function(cos, sin, sec, tan, csc, ctg, ln, log3, log10);

        System.out.println(function.compute(-1.5708));

//        writer.write("cos.csv", cos::compute, -10, 10, 0.1);
//        writer.write("sin.csv", sin::compute, -10, 10, 0.1);
//        writer.write("tan.csv", tan::compute, -Math.PI/3, Math.PI/3, 0.001);
//        writer.write("sec.csv", sec::compute, -10, 10, 0.1);
//        writer.write("ctg.csv", ctg::compute, Math.PI/6, Math.PI*5/6, 0.1);
        writer.write("csc.csv", csc::compute, -10, 10, 0.1);
//
//        writer.write("ln.csv", ln::compute, 0.1, 10, 0.1);
//        writer.write("ln.csv", log3::compute, 0.1, 10, 0.1);
//        writer.write("ln.csv", log10::compute, 0.1, 10, 0.1);

//        writer.write("function.csv", function::compute, -10, 10, 0.1);


    }
}
