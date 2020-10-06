package example;

import java.math.BigDecimal;
import java.math.BigInteger;

import app.zoftwhere.combinatoric.Series;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeriesExample {

    @Test
    void testLongValue() {
        // Series: sum{1, 2, 3, ..., 9, 10} = 55
        final var base = 1L;
        final var increment = 1L;
        final var exponent = 1;
        final var length = 10L;
        final var value = Series.calculate(base, increment, exponent, length);
        assertEquals(55L, value.longValue());
    }

    @Test
    void testBigIntegerValue() {
        // Series: sum{1, 2, 3, ..., 9, 10} = 55
        final var base = BigInteger.ONE;
        final var increment = BigInteger.ONE;
        final var exponent = 1;
        final var length = BigInteger.valueOf(10);
        final var value = Series.calculate(base, increment, exponent, length);
        assertEquals(55L, value.longValue());
    }

    @Test
    void testBigDecimalValue() {
        // Series: sum{1, 2, 3, ..., 9, 10} = 55
        final var base = BigDecimal.ONE;
        final var increment = BigDecimal.ONE;
        final var exponent = 1;
        final var length = BigInteger.valueOf(10);
        final var value = Series.calculate(base, increment, exponent, length);
        assertEquals(55d, value.doubleValue());
    }

}
