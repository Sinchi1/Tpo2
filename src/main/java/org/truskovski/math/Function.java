package org.truskovski.math;

import org.truskovski.math.log.Ln;
import org.truskovski.math.log.LogFunctions;
import org.truskovski.math.trigo.*;

public class Function implements MathFunction{

    Cos cos = new Cos();
    Sin sin = new Sin(cos);
    Sec sec = new Sec(cos);
    Tan tan = new Tan(cos, sin);
    Csc csc = new Csc(sin);
    Ctg ctg = new Ctg(cos, sin);

    Ln ln = new Ln();
    LogFunctions logBase = new LogFunctions();
    
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
            return (((logBase.log10(x) + ln.compute(x)) / logBase.log3(x)
                    + Math.pow(logBase.log3(x), 2)) * (logBase.log3(x) / ln.compute(x)))
                    / ln.compute(x);
        }
    }
}
