package app.zoftwhere.combinatoric;

import java.math.BigInteger;

class SequenceBigInteger extends AbstractSequence<BigInteger, BigInteger> {

    SequenceBigInteger(BigInteger base, BigInteger increment, int exponent, BigInteger length) {
        super(base, increment, exponent, length);
    }

    @Override
    public BigInteger sum() {
        return Series.calculate(base(), increment(), exponent(), length());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Sequence<BigInteger, BigInteger> newInstance(BigInteger base,
        BigInteger increment,
        int exponent,
        BigInteger length)
    {
        return new SequenceBigInteger(base, increment, exponent, length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigInteger convertValue(int value) {
        return BigInteger.valueOf(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigInteger convertValue(long value) {
        return BigInteger.valueOf(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigInteger convertLength(int length) {
        return BigInteger.valueOf(length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigInteger convertLength(long length) {
        return BigInteger.valueOf(length);
    }

}
