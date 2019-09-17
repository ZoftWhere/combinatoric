package main.combinatoric;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Generator.bigDecimalSequence;
import static app.zoftwhere.combinatoric.Generator.bigIntegerSequence;
import static app.zoftwhere.combinatoric.Generator.primitiveSequence;

/**
 * Test scope rules.
 */
class SequenceTest {

    @Test
    void testPrimitive() {
        primitiveSequence();
        primitiveSequence().base(0);
        primitiveSequence().base(0L);
        primitiveSequence().base(null);
        primitiveSequence().base(0).increment(1);
        primitiveSequence().base(0L).increment(1L);
        primitiveSequence().base(null).increment(null);
        primitiveSequence().base(0).increment(1).length(1);
        primitiveSequence().base(0L).increment(1L).length(1L);
        primitiveSequence().base(null).increment(null).length(null);
    }

    @Test
    void testBigInteger() {
        bigIntegerSequence();
        bigIntegerSequence().base(0);
        bigIntegerSequence().base(0L);
        bigIntegerSequence().base(null);
        bigIntegerSequence().base(0).increment(1);
        bigIntegerSequence().base(0L).increment(1L);
        bigIntegerSequence().base(null).increment(null);
        bigIntegerSequence().base(0).increment(1).length(1);
        bigIntegerSequence().base(0L).increment(1L).length(1L);
        bigIntegerSequence().base(null).increment(null).length(null);
    }

    @Test
    void testBigDecimal() {
        bigDecimalSequence();
        bigDecimalSequence().base(0);
        bigDecimalSequence().base(0L);
        bigDecimalSequence().base(null);
        bigDecimalSequence().base(0).increment(1);
        bigDecimalSequence().base(0L).increment(1L);
        bigDecimalSequence().base(null).increment(null);
        bigDecimalSequence().base(0).increment(1).length(1);
        bigDecimalSequence().base(0L).increment(1L).length(1L);
        bigDecimalSequence().base(null).increment(null).length(null);
    }

}