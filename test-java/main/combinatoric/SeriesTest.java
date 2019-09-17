package main.combinatoric;

import app.zoftwhere.combinatoric.Series;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Test scope rules.
 */
class SeriesTest {

    @Test
    void testCalculate() {
        Series.calculate(Long.valueOf(1), Long.valueOf(1), 0, Long.valueOf(1));
        Series.calculate(BigInteger.ONE, BigInteger.ONE, 0, BigInteger.TEN);
        Series.calculate(BigDecimal.ONE, BigDecimal.ONE, 0, BigInteger.TEN);
    }

    @Test
    void testNullBase() {
        try {
            Series.calculate(null, Long.valueOf(1), 0, Long.valueOf(1));
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(null, BigInteger.ONE, 0, BigInteger.TEN);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(null, BigDecimal.ONE, 0, BigInteger.TEN);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

    @Test
    void testNullIncrement() {
        try {
            Series.calculate(Long.valueOf(1), null, 0, Long.valueOf(1));
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(BigInteger.ONE, null, 0, BigInteger.TEN);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(BigDecimal.ONE, null, 0, BigInteger.TEN);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

    @Test
    void testNullLength() {
        try {
            Series.calculate(Long.valueOf(1), Long.valueOf(1), 0, null);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(BigInteger.ONE, BigInteger.ONE, 0, null);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(BigDecimal.ONE, BigDecimal.ONE, 0, null);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

    @Test
    void testZeroExponent() {
        try {
            Series.calculate(Long.valueOf(1), Long.valueOf(1), -1, Long.valueOf(1));
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(BigInteger.ONE, BigInteger.ONE, -1, BigInteger.TEN);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            Series.calculate(BigDecimal.ONE, BigDecimal.ONE, -1, BigInteger.TEN);
            Assertions.fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

}
