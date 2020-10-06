package example;

import java.math.BigDecimal;
import java.math.BigInteger;

import app.zoftwhere.combinatoric.Generator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>Sequence Example.
 * </p>
 * <p> The example shows the various ways to construct a sequence.
 * </p>
 *
 * @author Osmund
 * @since 2.1.0
 */
class SequenceExample {

    @Test
    void testPrimitive() {
        var expected = 237;
        var sequence = Generator.primitiveSequence();
        var base = 7;
        var increment = 13;
        var exponent = 1;
        var length = 6;
        var sum = sequence.base(base).increment(increment).exponent(exponent).length(length).sum();
        assertEquals(expected, sum);
    }

    @Test
    void testBigInteger() {
        var expected = new BigInteger("15743225838776547541");
        var sequence = Generator.bigIntegerSequence();
        var base = 9;
        var increment = 10;
        var exponent = 6;
        var length = 101;
        var sum = sequence.base(base).increment(increment).exponent(exponent).length(length).sum();
        assertEquals(expected, sum);
    }

    @Test
    void testBigDecimal() {
        var expected = new BigDecimal("21211575295124816437.0000");
        var sequence = Generator.bigDecimalSequence();
        var base = 0;
        var increment = BigDecimal.valueOf(1.1);
        var exponent = 4;
        var length = 9376;
        var sum = sequence.base(base).increment(increment).exponent(exponent).length(length).sum();
        assertEquals(expected, sum);
    }

}
