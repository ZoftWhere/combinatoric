package app.zoftwhere.combinatoric;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static app.zoftwhere.combinatoric.Generator.bigDecimalSequence;
import static app.zoftwhere.combinatoric.Generator.bigIntegerSequence;
import static app.zoftwhere.combinatoric.Generator.primitiveSequence;
import static org.junit.jupiter.api.Assertions.fail;

class SequenceTest {

    @Test
    void buildLongLinear() {
        for (var a = 0; a < 5; a++) {
            for (var d = -3; d < 3; d++) {
                for (var n = -5; n <= 5; n++) {
                    final var expected = controlLine(a, d, n);
                    long actual = primitiveSequence()
                        .base((long) a)
                        .increment((long) d)
                        .length(n)
                        .sum();

                    if (expected != actual) {
                        final var message = String.format("sum{%d, %d %d} == %d != %d", a, d, n, expected, actual);
                        fail(message);
                    }
                }
            }
        }
    }

    @Test
    void buildLongSquare() {
        for (var a = 0; a < 5; a++) {
            for (var d = -3; d < 3; d++) {
                for (var n = -5; n <= 5; n++) {
                    final var expected = controlSquare(a, d, n);
                    long actual = primitiveSequence()
                        .base((long) a)
                        .exponent(2)
                        .increment((long) d)
                        .length(n)
                        .sum();

                    if (expected != actual) {
                        final var message = String.format("sum{%d, %d %d} == %d != %d", a, d, n, expected, actual);
                        fail(message);
                    }
                }
            }
        }
    }

    @Test
    void buildLongCube() {
        for (var a = 0; a < 5; a++) {
            for (var d = -3; d < 3; d++) {
                for (var n = -5; n <= 5; n++) {
                    final var expected = controlCube(a, d, n);
                    long actual = primitiveSequence()
                        .base((long) a)
                        .exponent(3)
                        .increment((long) d)
                        .length(n)
                        .sum();

                    if (expected != actual) {
                        final var message = String.format("sum{%d, %d, %d} == %d != %d", a, d, n, expected, actual);
                        fail(message);
                    }
                }
            }
        }
    }

    @Test
    void buildBigInteger() {
        for (var p = 1; p <= 8; p++) {
            for (var a = 0; a < 5; a++) {
                for (var d = -3; d < 3; d++) {
                    for (var n = -5; n <= 5; n++) {
                        final var expected = control(a, d, p, n);
                        final var actual = bigIntegerSequence()
                            .base(BigInteger.valueOf(a))
                            .exponent(p)
                            .increment(d)
                            .length(n)
                            .sum();

                        if (expected.compareTo(actual) != 0) {
                            final var template = "sum{%d, %d, %d, %d} == %s != %s";
                            final var message = String.format(template, a, d, p, n, expected, actual);
                            fail(message);
                        }
                    }
                }
            }
        }
    }

    @Test
    void buildBigDecimal() {
        for (var p = 1; p <= 3; p++) {
            for (var a = 0; a < 5; a++) {
                for (var d = -3; d < 3; d++) {
                    for (var n = -5; n <= 5; n++) {
                        final var value = control(a, d, p, n);
                        final var expected = new BigDecimal(value);
                        final var actual = bigDecimalSequence()
                            .base(BigDecimal.valueOf(a))
                            .exponent(p)
                            .increment(d)
                            .length(n)
                            .sum();

                        if (expected.compareTo(actual) != 0) {
                            final var template = "sum{%d, %d, %d, %d} == %s != %s";
                            final var message = String.format(template, a, d, p, n, expected, actual);
                            fail(message);
                        }
                    }
                }
            }
        }
    }

    private long controlLine(long a, long d, long n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return controlLine(a, -d, -n);
        }
        var sum = a * n;
        for (var i = 1; i < n; i++) {
            sum += d * i;
        }
        return sum;
    }

    private long controlSquare(long a, long d, long n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return controlSquare(a, -d, -n);
        }
        long sum = 0;
        for (var i = 0; i < n; i++) {
            final var value = a + d * i;
            sum += value * value;
        }
        return sum;
    }

    private long controlCube(long a, long d, long n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return controlCube(a, -d, -n);
        }
        long sum = 0;
        for (var i = 0; i < n; i++) {
            final var value = a + d * i;
            sum += value * value * value;
        }
        return sum;
    }

    private BigInteger control(long a, long d, int p, long n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n < 0) {
            return control(a, -d, p, -n);
        }
        var sum = BigInteger.ZERO;
        for (var i = 0; i < n; i++) {
            final var value = a + d * i;
            sum = sum.add(BigInteger.valueOf(value).pow(p));
        }
        return sum;
    }

}