package app.zoftwhere.combinatoric;

import java.math.BigInteger;

/**
 * <p>Calculator.
 * </p>
 * <p>This is a public class for calculation functionality.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
public class Calculator {

    /**
     * Utility method for calculating a factorial.
     *
     * @param value input value
     * @return factorial for value
     * @throws IllegalArgumentException for negative value
     * @since 3.0.0
     */
    public static BigInteger factorial(int value) {
        if (value < 0) {
            final String message = "calculator.factorial.value.negative";
            final String template = "value: %d";
            final Exception cause = new Exception(String.format(template, value));
            throw new IllegalArgumentException(message, cause);
        }
        if (value < 2) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.valueOf(2);
        long temp = 1;
        long max = 1 << 24;

        for (int i = 3; i <= value; i++) {
            temp *= i;
            if (temp > max) {
                result = result.multiply(BigInteger.valueOf(temp));
                temp = 1;
            }
        }

        if (temp > 1) {
            result = result.multiply(BigInteger.valueOf(temp));
        }

        return result;
    }

    /**
     * Utility method for calculating a binomial coefficient.
     *
     * @param n number of elements
     * @param r elements to choose
     * @return binomial coefficient
     * @since 3.0.0
     */
    public static BigInteger nCr(int n, int r) {
        if (n < 0) {
            String message = "calculator.ncr.number.negative";
            Exception cause = new Exception("n: " + n);
            throw new IllegalArgumentException(message, cause);
        }

        if (r < 0 || n < r) {
            String message = "calculator.ncr.number.out.of.bound";
            Exception cause = new Exception("r: " + r);
            throw new IllegalArgumentException(message, cause);
        }

        if (r == 0 || n == r) {
            return BigInteger.ONE;
        }

        final int k = Math.min(r, n - r);
        BigInteger result = BigInteger.valueOf(n);

        for (int i = 1; i < k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
            result = result.divide(BigInteger.valueOf(i + 1));
        }

        return result;
    }

    /**
     * <p>Utility method for calculating partial permutations.
     * </p>
     * <p>Returns the number of k-permutations over n.
     * </p>
     *
     * @param n number of elements
     * @param k permutation sequence length
     * @return partial permutations
     * @since 3.0.0
     */
    public static BigInteger nPk(int n, int k) {
        if (n < 0) {
            String message = "calculator.npk.number.negative";
            Exception cause = new Exception("n: " + n);
            throw new IllegalArgumentException(message, cause);
        }

        if (k < 0 || n < k) {
            String message = "calculator.npk.number.out.of.bound";
            Exception cause = new Exception("k: " + k);
            throw new IllegalArgumentException(message, cause);
        }

        if (k == 0) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ONE;
        long temp = n;
        long max = 1 << 22;

        for (int i = n - k + 1; i < n; i++) {
            temp *= i;
            if (temp > max) {
                result = result.multiply(BigInteger.valueOf(temp));
                temp = 1;
            }
        }

        if (temp > 1) {
            result = result.multiply(BigInteger.valueOf(temp));
        }

        return result;
    }

}
