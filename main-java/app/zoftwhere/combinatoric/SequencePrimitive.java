package app.zoftwhere.combinatoric;

class SequencePrimitive extends AbstractSequence<Long, Long> {

    SequencePrimitive(Long base, Long increment, int exponent, Long length) {
        super(base, increment, exponent, length);
    }

    @Override
    public Long sum() {
        return Series.calculate(base(), increment(), exponent(), length());
    }

    @Override
    protected SequencePrimitive newInstance(Long base, Long increment, int exponent, Long length) {
        return new SequencePrimitive(base, increment, exponent, length);
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
