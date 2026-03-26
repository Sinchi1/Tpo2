package org.truskovski.math;

import org.truskovski.math.log.Ln;
import org.truskovski.math.log.Log10;
import org.truskovski.math.log.Log3;
import org.truskovski.math.trigo.*;

public class Function implements MathFunction{

    Cos cos = new Cos();
    Sin sin = new Sin(cos);
    Sec sec = new Sec(cos);
    Tan tan = new Tan(cos, sin);
    Csc csc = new Csc(sin);
    Ctg ctg = new Ctg(cos, sin);

    Ln ln = new Ln();
    Log3 log3 = new Log3(ln);
    Log10 log10 = new Log10(ln);


    @Override
    public double compute(double x) {

        if (x <= 0) {
            return Math.pow(
                    ((((((Math.pow(cos.compute(x), 3) / cos.compute(x)) * cos.compute(x)) / ctg.compute(x)
                            + Math.pow(sec.compute(x), 3) * (tan.compute(x) * sec.compute(x) + cos.compute(x)))
                            * (tan.compute(x) / csc.compute(x)) * csc.compute(x)
                            / ((sin.compute(x) * sin.compute(x)) / ctg.compute(x) + sec.compute(x)))
                            * ((sin.compute(x) - tan.compute(x))
                            / Math.pow((cos.compute(x) + sec.compute(x)) / sin.compute(x), 3) - ctg.compute(x)))
                            / (((((csc.compute(x) + cos.compute(x)) - sec.compute(x)
                            - (tan.compute(x) / ctg.compute(x) + Math.pow(ctg.compute(x), 2) / tan.compute(x))
                            + sec.compute(x)) * (sec.compute(x) - cos.compute(x) + csc.compute(x)))
                            * (tan.compute(x) * csc.compute(x)) * csc.compute(x)))),
                    3)
                    / ((csc.compute(x) + cos.compute(x) + sin.compute(x))
                    / (Math.pow(Math.pow(csc.compute(x) - cos.compute(x) * (sec.compute(x) / csc.compute(x)) - cos.compute(x), 3), 3)
                    / cos.compute(x)));
        } else {
            return (((log10.compute(x) + ln.compute(x)) / log3.compute(x)
                    + Math.pow(log3.compute(x), 2)) * (log3.compute(x) / ln.compute(x)))
                    / ln.compute(x);
        }
    }
}
