package app.zoftwhere.combinatoric.scope;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static app.zoftwhere.combinatoric.Series.calculate;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test scope rules.
 */
class SeriesScopeTest {

    @Test
    void testCalculate() {
        calculate(Long.valueOf(1), Long.valueOf(1), 0, Long.valueOf(1));
        calculate(BigInteger.ONE, BigInteger.ONE, 0, BigInteger.TEN);
        calculate(BigDecimal.ONE, BigDecimal.ONE, 0, BigInteger.TEN);
    }

    @Test
    void testNullBase() {
        try {
            calculate(null, Long.valueOf(1), 0, Long.valueOf(1));
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(null, BigInteger.ONE, 0, BigInteger.TEN);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(null, BigDecimal.ONE, 0, BigInteger.TEN);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

    @Test
    void testNullIncrement() {
        try {
            calculate(Long.valueOf(1), null, 0, Long.valueOf(1));
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(BigInteger.ONE, null, 0, BigInteger.TEN);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(BigDecimal.ONE, null, 0, BigInteger.TEN);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

    @Test
    void testNullLength() {
        try {
            calculate(Long.valueOf(1), Long.valueOf(1), 0, null);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(BigInteger.ONE, BigInteger.ONE, 0, null);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(BigDecimal.ONE, BigDecimal.ONE, 0, null);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

    @Test
    void testZeroExponent() {
        try {
            calculate(Long.valueOf(1), Long.valueOf(1), -1, Long.valueOf(1));
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(BigInteger.ONE, BigInteger.ONE, -1, BigInteger.TEN);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
        try {
            calculate(BigDecimal.ONE, BigDecimal.ONE, -1, BigInteger.TEN);
            fail("expected.null.pointer.exception");
        }
        catch (Exception ignored) {}
    }

}
