package app.zoftwhere.combinatoric;

import java.math.BigInteger;

class SeriesBigIntegerBuilder extends SeriesBuilderGeneric<BigInteger, BigInteger> {

    SeriesBigIntegerBuilder(BigInteger base, BigInteger increment, int exponent, BigInteger length) {
        super(new SeriesBigInteger(base, increment, exponent, length));
    }

    private SeriesBigIntegerBuilder(AbstractSeries<BigInteger, BigInteger> series) {
        super(series);
    }

    @Override
    public BigInteger sum() {
        return new SeriesCalculator().bigIntegerFunction().apply(this.build());
    }

    @Override
    protected SeriesBuilder<BigInteger, BigInteger> clone(AbstractSeries<BigInteger, BigInteger> series) {
        return new SeriesBigIntegerBuilder(series);
    }

}
