package app.zoftwhere.combinatoric;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p>Sequence BigDecimal.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
 */
class SequenceBigDecimal extends AbstractSequence<BigDecimal, BigInteger> {


    /**
     * Constructor for {@link app.zoftwhere.combinatoric.SequenceBigDecimal} (package-private).
     *
     * @param base      base
     * @param increment increment
     * @param exponent  exponent
     * @param length    length
     */
    SequenceBigDecimal(BigDecimal base, BigDecimal increment, int exponent, BigInteger length) {
        super(base, increment, exponent, length);
    }

    /** {@inheritDoc} */
    @Override
    protected Sequence<BigDecimal, BigInteger> newInstance(BigDecimal base,
        BigDecimal increment,
        int exponent,
        BigInteger length)
    {
        return new SequenceBigDecimal(base, increment, exponent, length);
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal sum() {
        return Series.calculate(base(), increment(), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    protected BigDecimal convertValue(int value) {
        return BigDecimal.valueOf(value);
    }

    /** {@inheritDoc} */
    @Override
    protected BigDecimal convertValue(long value) {
        return BigDecimal.valueOf(value);
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
