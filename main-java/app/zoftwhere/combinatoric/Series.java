package app.zoftwhere.combinatoric;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Series {

    /**
     * Calculates the series for the summation of form <code>term(base + increment * x).pow(exponent)</code>
     *
     * @param base      the base value
     * @param increment the increment value
     * @param exponent  the exponent value
     * @param length    the number of summation elements
     * @return the series
     */
    public static Long calculate(Long base, Long increment, int exponent, Long length) {
        BigDecimal a = base != null ? new BigDecimal(base) : null;
        BigDecimal d = increment != null ? new BigDecimal(increment) : null;
        BigInteger n = length != null ? BigInteger.valueOf(length) : null;
        return calculate(a, d, exponent, n).longValueExact();
    }

    /**
     * Calculates the series for the summation of form <code>term(base + increment * x).pow(exponent)</code>
     *
     * @param base      the base value
     * @param increment the increment value
     * @param exponent  the exponent value
     * @param length    the number of summation elements
     * @return the series
     */
    public static BigInteger calculate(BigInteger base, BigInteger increment, int exponent, BigInteger length) {
        BigDecimal a = base != null ? new BigDecimal(base) : null;
        BigDecimal d = increment != null ? new BigDecimal(increment) : null;
        return calculate(a, d, exponent, length).toBigIntegerExact();
    }

    /**
     * Calculates the series for the summation of form <code>term(base + increment * x).pow(exponent)</code>
     *
     * @param base      the base value
     * @param increment the increment value
     * @param exponent  the exponent value
     * @param length    the number of summation elements
     * @return the series
     */
    public static BigDecimal calculate(BigDecimal base, BigDecimal increment, int exponent, BigInteger length) {
        if (base == null) {
            throw new NullPointerException("series.base.null");
        }
        if (increment == null) {
            throw new NullPointerException("series.increment.null");
        }
        if (length == null) {
            throw new NullPointerException("series.length.null");
        }
        if (exponent < 0) {
            throw new UnsupportedOperationException("series.negative.exponent.unsupported");
        }

        BigDecimal d = length.signum() < 0 ? increment.negate() : increment;
        BigInteger n = length.signum() < 0 ? length.negate() : length;

        return new Series().summation(base, d, exponent, n);
    }

    Series() {
    }

    /**
     * Calculates the summation of form <code>term(a + d * x).pow(exponent)</code>
     *
     * @param a the base value
     * @param d the increment value
     * @param p the exponent value
     * @param n the number of summation elements
     * @return the summation
     */
    BigDecimal summation(BigDecimal a, BigDecimal d, int p, BigInteger n) {
        if (n.signum() == 0) {
            return BigDecimal.ZERO;
        }

        BigInteger nm1 = n.subtract(BigInteger.ONE);

        if (p == 0) {
            if (a.signum() == 0) {
                throw new IllegalArgumentException("series.zero.power.zero");
            }

            return new BigDecimal(n.abs());
        }

        if (a.signum() == 0) {
            BigDecimal dp = d.pow(p);
            BigInteger ns = sequenceVariableSum(nm1, p);
            return new BigDecimal(ns).multiply(dp);
        }

        BigDecimal sum = a.pow(p).multiply(new BigDecimal(n));

        if (d.signum() == 0) {
            return sum;
        }

        int ckn = p + 1;
        int ck = 1;

        for (int e = 1; e <= p; e++) {
            ck = ck * (ckn - e) / (e);

            BigDecimal ap = a.pow(p - e);
            BigDecimal dp = d.pow(e);
            BigInteger ns = BigInteger.valueOf(ck).multiply(sequenceVariableSum(nm1, e));
            BigDecimal product = new BigDecimal(ns).multiply(ap).multiply(dp);
            sum = sum.add(product);
        }

        return sum;
    }

    /**
     * <p>Calculates the value for the summation:
     * </p>
     * <p>sum{ i = 0...n-1, n^power }
     * </p>
     *
     * @param n     the length of the summation
     * @param power the exponent for each term
     * @return the summation
     */
    BigInteger sequenceVariableSum(BigInteger n, int power) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger t3d = sequenceProduct(BigInteger.ZERO, 1, power + 1);

        // Calculate the binomial coefficients.
        BigInteger[] bc = new BigInteger[power + 1];
        int cr = 1;
        bc[0] = BigInteger.ONE;
        for (int i = 1; i < power + 2 - i; i++) {
            cr = cr * (power + 2 - i) / (i);
            bc[i] = BigInteger.valueOf(cr);
            bc[power + 1 - i] = bc[i];
        }

        // Calculate the sum of the sequence.
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

    /**
     * Calculates the product of sequence of value from <code>n + min(left, right)</code> to <code>n + max(left,
     * right)</code>.
     *
     * @param n     the base value
     * @param left  the increment for the left
     * @param right the increment for the right
     * @return the product of the sequence.
     */
    BigInteger sequenceProduct(BigInteger n, int left, int right) {
        int min = Math.min(left, right);
        int max = Math.max(left, right);

        BigInteger product = BigInteger.ONE;
        for (int i = min; i <= max; i++) {
            product = product.multiply(n.add(BigInteger.valueOf(i)));
        }
        return product;
    }

}
