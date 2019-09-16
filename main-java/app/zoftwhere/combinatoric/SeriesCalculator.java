package app.zoftwhere.combinatoric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;

class SeriesCalculator {

    SeriesCalculator() {
    }

    private BigDecimal seriesSum(BigDecimal a, BigDecimal d, int exponent, BigInteger n) {
        if (n.signum() == 0) {
            return BigDecimal.ZERO;
        }

        BigInteger nm1 = n.subtract(BigInteger.ONE);

        if (exponent == 0) {
            if (a.signum() == 0) {
                throw new IllegalArgumentException("zero.power.zero");
            }

            return new BigDecimal(n.abs());
        }

        if (a.signum() == 0) {
            BigDecimal dp = d.pow(exponent);
            BigInteger ns = seriesSum(nm1, exponent);
            return new BigDecimal(ns).multiply(dp);
        }

        BigDecimal sum = a.pow(exponent).multiply(new BigDecimal(n));

        if (d.signum() == 0) {
            return sum;
        }

        int ckn = exponent + 1;
        int ck = 1;

        for (int p = 1; p <= exponent; p++) {
            ck = ck * (ckn - p) / (p);

            BigDecimal ap = a.pow(exponent - p);
            BigDecimal dp = d.pow(p);
            BigInteger ns = BigInteger.valueOf(ck).multiply(seriesSum(nm1, p));
            BigDecimal product = new BigDecimal(ns).multiply(ap).multiply(dp);
            sum = sum.add(product);
        }

        return sum;
    }

    Function<Series<BigDecimal, BigInteger>, BigDecimal> bigDecimalFunction() {
        return series -> {
            BigDecimal a = series.base();
            BigDecimal d = series.length().signum() < 0 ? series.increment().negate() : series.increment();
            BigInteger n = series.length().signum() < 0 ? series.length().negate() : series.length();
            int p = series.exponent();

            return seriesSum(a, d, p, n);
        };
    }

    Function<Series<BigInteger, BigInteger>, BigInteger> bigIntegerFunction() {
        return series -> {
            BigInteger a = series.base();
            BigInteger d = series.length().signum() < 0 ? series.increment().negate() : series.increment();
            BigInteger n = series.length().signum() < 0 ? series.length().negate() : series.length();
            int p = series.exponent();

            BigDecimal result = seriesSum(new BigDecimal(a), new BigDecimal(d), p, n);
            return result.toBigIntegerExact();
        };
    }

    Function<Series<Long, Long>, Long> longFunction() {
        return series -> {
            Long a = series.base();
            Long d = series.length() < 0 ? 0 - series.increment() : series.increment();
            Long n = series.length() < 0 ? 0 - series.length() : series.length();
            int p = series.exponent();

            BigDecimal result = seriesSum(new BigDecimal(a), new BigDecimal(d), p, BigInteger.valueOf(n));
            return result.toBigIntegerExact().longValue();
        };
    }

    private BigInteger seriesSum(BigInteger n, int power) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger t3d = sequenceProduct(BigInteger.ZERO, 1, power + 1);

        BigInteger[] bc = new BigInteger[power + 1];
        int cr = 1;
        bc[0] = BigInteger.ONE;
        for (int i = 1; i < power + 2 - i; i++) {
            cr = cr * (power + 2 - i) / (i);
            bc[i] = BigInteger.valueOf(cr);
            bc[power + 1 - i] = bc[i];
        }

        for (int i = 1; i <= power; i++) {
            BigInteger t3 = sequenceProduct(n, 0 - i + 1, power - i + 1)
                .divide(t3d);

            for (int j = 0; j <= i - 1; j++) {
                BigInteger t2 = BigInteger.valueOf(i - j).pow(power);
                BigInteger t4 = bc[j];
                BigInteger q = (t2).multiply(t3).multiply(t4);
                // sum { i=1..p, sum { j=0..i-1, { (-1)^j (i-j)^p nCk{ n+p-i+1; n-i} nCk{ p+1, j } } } }
                sum = (j & 0x1) == 0 ? sum.add(q) : sum.add(q.negate());
            }
        }

        return sum;
    }

    private BigInteger sequenceProduct(BigInteger n, int left, int right) {
        int min = Math.min(left, right);
        int max = Math.max(left, right);

        BigInteger product = BigInteger.ONE;
        for (int i = min; i <= max; i++) {
            product = product.multiply(n.add(BigInteger.valueOf(i)));
        }
        return product;
    }

}
