package app.zoftwhere.combinatoric;

abstract class SeriesBuilderGeneric<T, L> extends SeriesBuilder<T, L> {

    private final AbstractSeries<T, L> series;

    SeriesBuilderGeneric(AbstractSeries<T, L> series) {
        this.series = series;
    }

    protected abstract SeriesBuilder<T, L> clone(AbstractSeries<T, L> series);

    @Override
    public SeriesBuilder<T, L> base(int base) {
        return clone(series.base(base));
    }

    @Override
    public SeriesBuilder<T, L> base(long base) {
        return clone(series.base(base));
    }

    @Override
    public SeriesBuilder<T, L> base(T base) {
        return clone(series.base(base));
    }

    @Override
    public SeriesBuilder<T, L> increment(int increment) {
        return clone(series.increment(increment));
    }

    @Override
    public SeriesBuilder<T, L> increment(long increment) {
        return clone(series.increment(increment));
    }

    @Override
    public SeriesBuilder<T, L> increment(T increment) {
        return clone(series.increment(increment));
    }

    @Override
    public SeriesBuilder<T, L> exponent(int exponent) {
        return clone(series.exponent(exponent));
    }

    @Override
    public SeriesBuilder<T, L> length(int length) {
        return clone(series.length(length));
    }

    @Override
    public SeriesBuilder<T, L> length(long length) {
        return clone(series.length(length));
    }

    @Override
    public SeriesBuilder<T, L> length(L length) {
        return clone(series.length(length));
    }

    @Override
    public AbstractSeries<T, L> build() {
        return series;
    }

}
