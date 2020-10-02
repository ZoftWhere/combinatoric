package app.zoftwhere.combinatoric;

import java.math.BigInteger;

/**
 * <p>Sequence BigInteger.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
 */
class SequenceBigInteger extends AbstractSequence<BigInteger, BigInteger> {

    /**
     * Constructor for {@link app.zoftwhere.combinatoric.SequenceBigInteger} (package-private).
     * @param base base
     * @param increment increment
     * @param exponent exponent
     * @param length length
     */
    SequenceBigInteger(BigInteger base, BigInteger increment, int exponent, BigInteger length) {
        super(base, increment, exponent, length);
    }

    /** {@inheritDoc} */
    @Override
    protected Sequence<BigInteger, BigInteger> newInstance(BigInteger base,
        BigInteger increment,
        int exponent,
        BigInteger length)
    {
        return new SequenceBigInteger(base, increment, exponent, length);
    }

    /** {@inheritDoc} */
    @Override
    public BigInteger sum() {
        return Series.calculate(base(), increment(), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    protected BigInteger convertValue(int value) {
        return BigInteger.valueOf(value);
    }

    /** {@inheritDoc} */
    @Override
    protected BigInteger convertValue(long value) {
        return BigInteger.valueOf(value);
    }

    /** {@inheritDoc} */
    @Override
    protected BigInteger convertLength(int length) {
        return BigInteger.valueOf(length);
    }

    /** {@inheritDoc} */
    @Override
    protected BigInteger convertLength(long length) {
        return BigInteger.valueOf(length);
    }

}
