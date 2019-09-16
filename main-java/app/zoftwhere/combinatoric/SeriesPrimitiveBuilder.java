package app.zoftwhere.combinatoric;

class SeriesPrimitiveBuilder extends SeriesBuilderGeneric<Long, Long> {

    SeriesPrimitiveBuilder(Long base, Long increment, int exponent, Long length) {
        super(new SeriesPrimitive(base, increment, exponent, length));
    }

    private SeriesPrimitiveBuilder(AbstractSeries<Long, Long> series) {
        super(series);
    }

    @Override
    public Long sum() {
        return new SeriesCalculator().longFunction().apply(this.build());
    }

    @Override
    protected SeriesBuilder<Long, Long> clone(AbstractSeries<Long, Long> series) {
        return new SeriesPrimitiveBuilder(series);
    }
}
