package app.zoftwhere.combinatoric;

import java.math.BigDecimal;
import java.math.BigInteger;

class SeriesBigDecimalBuilder extends SeriesBuilderGeneric<BigDecimal, BigInteger> {

    SeriesBigDecimalBuilder(BigDecimal base, BigDecimal increment, int exponent, BigInteger length) {
        super(new SeriesBigDecimal(base, increment, exponent, length));
    }

    private SeriesBigDecimalBuilder(AbstractSeries<BigDecimal, BigInteger> series) {
        super(series);
    }

    @Override
    public BigDecimal sum() {
        return new SeriesCalculator().bigDecimalFunction().apply(this.build());
    }

    @Override
    protected SeriesBuilder<BigDecimal, BigInteger> clone(AbstractSeries<BigDecimal, BigInteger> series) {
        return new SeriesBigDecimalBuilder(series);
    }

}
