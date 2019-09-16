package app.zoftwhere.combinatoric;

class SeriesPrimitive extends AbstractSeries<Long, Long> {

    SeriesPrimitive(Long base, Long increment, int exponent, Long length) {
        super(base, increment, exponent, length);
    }

    @Override
    protected SeriesPrimitive clone(Long base, Long increment, int exponent, Long length) {
        return new SeriesPrimitive(base, increment, exponent, length);
    }

    @Override
    protected Long convertValue(int value) {
        return (long) value;
    }

    @Override
    protected Long convertValue(long value) {
        return value;
    }

    @Override
    protected Long convertLength(int length) {
        return (long) length;
    }

    @Override
    protected Long convertLength(long length) {
        return length;
    }

}
