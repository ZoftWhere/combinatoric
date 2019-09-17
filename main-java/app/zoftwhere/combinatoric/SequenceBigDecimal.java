package app.zoftwhere.combinatoric;

import java.math.BigDecimal;
import java.math.BigInteger;

class SequenceBigDecimal extends AbstractSequence<BigDecimal, BigInteger> {

    SequenceBigDecimal(BigDecimal base, BigDecimal increment, int exponent, BigInteger length) {
        super(base, increment, exponent, length);
    }

    @Override
    public BigDecimal sum() {
        return Series.calculate(base(), increment(), exponent(), length());
    }

    @Override
    protected Sequence<BigDecimal, BigInteger> newInstance(BigDecimal base,
        BigDecimal increment,
        int exponent,
        BigInteger length)
    {
        return new SequenceBigDecimal(base, increment, exponent, length);
    }

    @Override
    protected BigDecimal convertValue(int value) {
        return BigDecimal.valueOf(value);
    }

    @Override
    protected BigDecimal convertValue(long value) {
        return BigDecimal.valueOf(value);
    }

    @Override
    protected BigInteger convertLength(int length) {
        return BigInteger.valueOf(length);
    }

    @Override
    protected BigInteger convertLength(long length) {
        return BigInteger.valueOf(length);
    }

}
