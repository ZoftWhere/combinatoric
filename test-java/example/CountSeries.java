package example;

import app.zoftwhere.combinatoric.Generator;

import java.math.BigDecimal;

import static app.zoftwhere.combinatoric.Generator.primitiveSequence;

class CountSeries {

    public static void main(String[] args) {
        long value = primitiveSequence()
            .base(1)
            .increment(3)
            .exponent(3)
            .length(3)
            .sum();

        // 1^2 + 4^3 + 7^3 = 408
        System.out.println(value);

        // 237
        System.out.println(Generator.primitiveSequence()
            .base(7).increment(13).length(6).sum()
        );

        // 15743225838776547541
        System.out.println(Generator.bigIntegerSequence()
            .base(9).exponent(6).increment(10).length(101).sum()
        );

        // 21211575295124816437.0000
        System.out.println(Generator.bigDecimalSequence()
            .base(0).increment(BigDecimal.valueOf(1.1d)).exponent(4).length(9376).sum()
        );
    }

}
