package example;

import java.math.BigDecimal;

import app.zoftwhere.combinatoric.Generator;
import app.zoftwhere.combinatoric.Sequence;

public class SequenceExample {

    @SuppressWarnings({"UnusedAssignment", "unused"})
    public static void main(String[] args) {
        Object series;
        Sequence<Long, Long> sequence, series10, series20;

        sequence = Generator.primitiveSequence();
        series10 = sequence.length(10);
        series20 = sequence.length(20);

        // 237
        series = Generator.primitiveSequence()
            .base(7).increment(13).length(6).sum();
        System.out.println(series);

        // 15743225838776547541
        series = Generator.bigIntegerSequence()
            .base(9).increment(10).exponent(6).length(101).sum();
        System.out.println(series);

        // 21211575295124816437.0000
        series = Generator.bigDecimalSequence()
            .base(0).increment(BigDecimal.valueOf(1.1)).exponent(4).length(9376).sum();
        System.out.println(series);
    }

}
