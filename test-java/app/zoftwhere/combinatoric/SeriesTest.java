package app.zoftwhere.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;
import java.util.function.Supplier;

import static app.zoftwhere.combinatoric.Generator.bigDecimalSequence;
import static app.zoftwhere.combinatoric.Generator.bigIntegerSequence;
import static app.zoftwhere.combinatoric.Generator.primitiveSequence;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SeriesTest {

    @Test
    void testPrimitive() {
        assertEquals(Long.valueOf(1), primitiveSequence().sum());
        Sequence<Long, Long> sequence = primitiveSequence();
        Long actual = Series.calculate(sequence.base(), sequence.increment(), sequence.exponent(), sequence.length());
        assertEquals(Long.valueOf(1), Series.calculate(sequence.base(), sequence.increment(), sequence.exponent(), sequence.length()));
        assertEquals(Long.valueOf(1), actual);
    }

    @Test
    void testBigInteger() {
        assertEquals(BigInteger.ONE, bigIntegerSequence().sum());
        Sequence<BigInteger, BigInteger> sequence = bigIntegerSequence();
        BigInteger actual = Series.calculate(sequence.base(), sequence.increment(), sequence.exponent(), sequence.length());
        assertEquals(BigInteger.ONE, Series.calculate(sequence.base(), sequence.increment(), sequence.exponent(), sequence.length()));
        assertEquals(BigInteger.ONE, actual);
    }

    @Test
    void testBigDecimal() {
        assertEquals(BigDecimal.ONE, bigDecimalSequence().sum());
        Sequence<BigDecimal, BigInteger> sequence = bigDecimalSequence();
        BigDecimal actual = Series.calculate(sequence.base(), sequence.increment(), sequence.exponent(), sequence.length());
        assertEquals(BigDecimal.ONE, Series.calculate(sequence.base(), sequence.increment(), sequence.exponent(), sequence.length()));
        assertEquals(BigDecimal.ONE, actual);
    }

    @Test
    void testSummation() {
        // TODO
        new Series().summation(BigDecimal.ONE, BigDecimal.ZERO, 1, BigInteger.TEN);
    }

    @Test
    void testSummationVariable() {
        // TODO
        new Series().sequenceVariableSum(BigInteger.TEN, 2);
    }

    @Test
    void testSequenceProduct() {
        // TODO
        new Series().sequenceProduct(BigInteger.TEN, -2, 2);
    }

    @Test
    void testLongLimit() {
        Long expected = Long.MAX_VALUE;
        Long actual;

        actual = primitiveSequence().base(1).increment(0).exponent(0).length(Long.MAX_VALUE).sum();
        assertEquals(expected, actual);

        actual = primitiveSequence().base(1).increment(0).exponent(1).length(Long.MAX_VALUE).sum();
        assertEquals(expected, actual);

        actual = primitiveSequence().base(1).increment(1).exponent(0).length(Long.MAX_VALUE).sum();
        assertEquals(expected, actual);

        try {
            runTest(Generator::primitiveSequence, Long::parseLong, Long::parseLong)
                .base("1024").increment("0").exponent("10").length("1")
                .expected("0");
            fail("expected.argument.overflow.exception");
        }
        catch (Exception ignore) {
        }
    }

    @Test
    void testZeroBase() {
        primitiveSequence().base(0).sum();
        primitiveSequence().base(0L).sum();

        bigIntegerSequence().base(0).sum();
        bigIntegerSequence().base(0L).sum();

        bigDecimalSequence().base(0).sum();
        bigDecimalSequence().base(0L).sum();
    }

    @Test
    void zeroExponent() {
        try {
            primitiveSequence().base(0).exponent(0).sum();
            Assertions.fail("expected.illegal.argument.exception");
        }
        catch (Exception ignore) {
        }

        try {
            bigIntegerSequence().base(0).exponent(0).sum();
            Assertions.fail("expected.illegal.argument.exception");
        }
        catch (Exception ignore) {
        }

        try {
            bigDecimalSequence().base(0).exponent(0).sum();
            Assertions.fail("expected.illegal.argument.exception");
        }
        catch (Exception ignore) {
        }
    }

    @Test
    void testZeroLength() {
        primitiveSequence().length(0).sum();
        bigIntegerSequence().length(0).sum();
        bigDecimalSequence().length(0).sum();

        runTest(Generator::primitiveSequence, Long::parseLong, Long::parseLong)
            .base("0").increment("0").exponent("0").length("0")
            .expected("0");

        runTest(Generator::bigIntegerSequence, BigInteger::new, BigInteger::new)
            .base("0").increment("0").exponent("0").length("0")
            .expected("0");

        runTest(Generator::bigDecimalSequence, BigDecimal::new, BigInteger::new)
            .base("0").increment("0").exponent("0").length("0")
            .expected("0");
    }

    @Test
    void testConversions() {

        runTest(Generator::primitiveSequence, Long::parseLong, Long::parseLong)
            .base("-2").increment("1").exponent("2").length("5")
            .expected("10");

        runTest(Generator::bigIntegerSequence, BigInteger::new, BigInteger::new)
            .base("1024").increment("0").exponent("10").length("1")
            .expected("1267650600228229401496703205376");

        runTest(Generator::bigDecimalSequence, BigDecimal::new, BigInteger::new)
            .base("-1.1").increment("1.1").exponent("10").length("3")
            .expected("5.1874849202");
    }

    private <T, L> TestRunner<T, L> runTest(
        Supplier<Sequence<T, L>> supplier,
        Function<String, T> parseValue,
        Function<String, L> parseLength)
    {
        return new TestRunner<>(supplier, parseValue, parseLength);
    }

    public static class TestRunner<T, L> {

        private final Supplier<Sequence<T, L>> supplier;
        private final Function<String, T> parseValue;
        private final Function<String, L> parseLength;
        private final String base;
        private final String increment;
        private final String exponent;
        private final String length;

        public TestRunner(Supplier<Sequence<T, L>> supplier,
            Function<String, T> parseValue,
            Function<String, L> parseLength)
        {
            this.supplier = supplier;
            this.parseValue = parseValue;
            this.parseLength = parseLength;
            this.base = null;
            this.increment = null;
            this.exponent = null;
            this.length = null;
        }

        private TestRunner(Supplier<Sequence<T, L>> supplier,
            Function<String, T> parseValue,
            Function<String, L> parseLength, String base, String increment, String exponent, String length)
        {
            this.supplier = supplier;
            this.parseValue = parseValue;
            this.parseLength = parseLength;
            this.base = base;
            this.increment = increment;
            this.exponent = exponent;
            this.length = length;
        }

        private TestRunner<T, L> base(String base) {
            return new TestRunner<>(supplier, parseValue, parseLength, base, increment, exponent, length);
        }

        private TestRunner<T, L> increment(String increment) {
            return new TestRunner<>(supplier, parseValue, parseLength, base, increment, exponent, length);
        }

        private TestRunner<T, L> exponent(String exponent) {
            return new TestRunner<>(supplier, parseValue, parseLength, base, increment, exponent, length);
        }

        private TestRunner<T, L> length(String length) {
            return new TestRunner<>(supplier, parseValue, parseLength, base, increment, exponent, length);
        }

        private void expected(String expected) {
            assert base != null;
            assert increment != null;
            assert exponent != null;
            assert length != null;
            String actual = supplier.get()
                .base(parseValue.apply(base))
                .increment(parseValue.apply(increment))
                .exponent(Integer.parseInt(exponent))
                .length(parseLength.apply(length))
                .sum().toString();
            Assertions.assertEquals(expected, actual);
        }

    }

}