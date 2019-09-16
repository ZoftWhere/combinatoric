package app.zoftwhere.combinatoric;

import java.math.BigInteger;

class SeriesBigInteger extends AbstractSeries<BigInteger, BigInteger> {

    SeriesBigInteger(BigInteger base, BigInteger increment, int exponent, BigInteger length) {
        super(base, increment, exponent, length);
    }

    @Override
    protected SeriesBigInteger clone(BigInteger base, BigInteger increment, int exponent, BigInteger length) {
        return new SeriesBigInteger(base, increment, exponent, length);
    }

    @Override
    protected BigInteger convertValue(int value) {
        return BigInteger.valueOf(value);
    }

    @Override
    protected BigInteger convertValue(long value) {
        return BigInteger.valueOf(value);
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
