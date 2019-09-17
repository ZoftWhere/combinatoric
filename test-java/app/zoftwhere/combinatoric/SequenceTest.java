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
        for (int a = 0; a < 5; a++) {
            for (int d = -3; d < 3; d++) {
                for (int n = -5; n <= 5; n++) {
                    long expected = controlLine(a, d, n);
                    long actual = primitiveSequence()
                        .base((long) a)
                        .increment((long) d)
                        .length(n)
                        .sum();

                    if (expected != actual) {
                        String message = String.format("sum{%d, %d %d} == %d != %d", a, d, n, expected, actual);
                        fail(message);
                    }
                }
            }
        }
    }

    @Test
    void buildLongSquare() {
        for (int a = 0; a < 5; a++) {
            for (int d = -3; d < 3; d++) {
                for (int n = -5; n <= 5; n++) {
                    long expected = controlSquare(a, d, n);
                    long actual = primitiveSequence()
                        .base((long) a)
                        .exponent(2)
                        .increment((long) d)
                        .length(n)
                        .sum();

                    if (expected != actual) {
                        String message = String.format("sum{%d, %d %d} == %d != %d", a, d, n, expected, actual);
                        fail(message);
                    }
                }
            }
        }
    }

    @Test
    void buildLongCube() {
        for (int a = 0; a < 5; a++) {
            for (int d = -3; d < 3; d++) {
                for (int n = -5; n <= 5; n++) {
                    long expected = controlCube(a, d, n);
                    long actual = primitiveSequence()
                        .base((long) a)
                        .exponent(3)
                        .increment((long) d)
                        .length(n)
                        .sum();

                    if (expected != actual) {
                        String message = String.format("sum{%d, %d, %d} == %d != %d", a, d, n, expected, actual);
                        fail(message);
                    }
                }
            }
        }
    }

    @Test
    void buildBigInteger() {
        for (int p = 1; p <= 8; p++) {
            for (int a = 0; a < 5; a++) {
                for (int d = -3; d < 3; d++) {
                    for (int n = -5; n <= 5; n++) {
                        BigInteger expected = control(a, d, p, n);
                        BigInteger actual = bigIntegerSequence()
                            .base(BigInteger.valueOf(a))
                            .exponent(p)
                            .increment(d)
                            .length(n)
                            .sum();

                        if (expected.compareTo(actual) != 0) {
                            String message = String.format("sum{%d, %d, %d, %d} == %d != %d", a, d, p, n, expected, actual);

                            control(a, d, n, p);

                            bigIntegerSequence()
                                .base(BigInteger.valueOf(a))
                                .exponent(p)
                                .increment(d)
                                .length(n)
                                .sum();

                            fail(message);
                        }
                    }
                }
            }
        }
    }

    @Test
    void buildBigDecimal() {
        for (int p = 1; p <= 3; p++) {
            for (int a = 0; a < 5; a++) {
                for (int d = -3; d < 3; d++) {
                    for (int n = -5; n <= 5; n++) {
                        BigInteger value = control(a, d, p, n);
                        BigDecimal expected = new BigDecimal(value);
                        BigDecimal actual = bigDecimalSequence()
                            .base(BigDecimal.valueOf(a))
                            .exponent(p)
                            .increment(d)
                            .length(n)
                            .sum();

                        if (expected.compareTo(actual) != 0) {
                            String message = String.format("sum{%d, %d, %d, %d} == %s != %s", a, d, p, n, expected, actual);

                            bigDecimalSequence()
                                .base(BigDecimal.valueOf(a))
                                .exponent(p)
                                .increment(d)
                                .length(n)
                                .sum();

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
        long sum = a * n;
        for (int i = 1; i < n; i++) {
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
        for (int i = 0; i < n; i++) {
            long value = a + d * i;
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
        for (int i = 0; i < n; i++) {
            long value = a + d * i;
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
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            long value = a + d * i;
            sum = sum.add(BigInteger.valueOf(value).pow(p));
        }
        return sum;
    }

}