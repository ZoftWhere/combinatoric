package app.zoftwhere.combinatoric;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class SeriesBuilder<T, L> {

    public SeriesBuilder() {
    }

    public abstract SeriesBuilder<T, L> base(int base);

    public abstract SeriesBuilder<T, L> base(long base);

    public abstract SeriesBuilder<T, L> base(T base);

    public abstract SeriesBuilder<T, L> increment(int increment);

    public abstract SeriesBuilder<T, L> increment(long increment);

    public abstract SeriesBuilder<T, L> increment(T increment);

    public abstract SeriesBuilder<T, L> exponent(int exponent);

    public abstract SeriesBuilder<T, L> length(int length);

    public abstract SeriesBuilder<T, L> length(long length);

    public abstract SeriesBuilder<T, L> length(L length);

    public abstract AbstractSeries<T, L> build();

    public abstract T sum();

    public static SeriesBuilder<Long, Long> primitiveSeries() {
        Long base = 1L;
        Long increment = 1L;
        int exponent = 1;
        Long length = 1L;
        return new SeriesPrimitiveBuilder(base, increment, exponent, length);
    }

    public static SeriesBuilder<BigInteger, BigInteger> bigIntegerSeries() {
        BigInteger base = BigInteger.ONE;
        BigInteger increment = BigInteger.ONE;
        int exponent = 1;
        BigInteger length = BigInteger.ONE;
        return new SeriesBigIntegerBuilder(base, increment, exponent, length);
    }

    public static SeriesBuilder<BigDecimal, BigInteger> bigDecimalSeries() {
        BigDecimal base = BigDecimal.ONE;
        BigDecimal increment = BigDecimal.ONE;
        int exponent = 1;
        BigInteger length = BigInteger.ONE;
        return new SeriesBigDecimalBuilder(base, increment, exponent, length);
    }

}
