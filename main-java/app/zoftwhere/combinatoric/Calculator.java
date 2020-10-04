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
            final String message = "combinatoric.factorial.value.negative";
            final String template = "value: %d";
            final Exception cause = new Exception(String.format(template, value));
            throw new IllegalArgumentException(message, cause);
        }
        if (value < 2) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.valueOf(2);
        long temp = 1;
        for (var i = 3; i <= value; i++) {
            temp *= i;
            if (temp > Integer.MAX_VALUE) {
                result = result.multiply(BigInteger.valueOf(temp));
                temp = 1;
            }
        }
        if (temp != 1) {
            result = result.multiply(BigInteger.valueOf(temp));
        }
        return result;
    }

}
