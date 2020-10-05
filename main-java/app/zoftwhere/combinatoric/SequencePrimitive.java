package app.zoftwhere.combinatoric;

/**
 * <p>Sequence Primitive.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
 * @since 2.0.0
 */
class SequencePrimitive extends AbstractSequence<Long, Long> {

    /**
     * Constructor for {@link app.zoftwhere.combinatoric.SequencePrimitive} (package-private).
     *
     * @param base      base value
     * @param increment increment value
     * @param exponent  exponent value
     * @param length    sequence length
     * @since 2.0.0
     */
    SequencePrimitive(Long base, Long increment, int exponent, Long length) {
        super(base, increment, exponent, length);
    }

    /** {@inheritDoc} */
    @Override
    public Long sum() {
        return Series.calculate(base(), increment(), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    protected SequencePrimitive newInstance(Long base, Long increment, int exponent, Long length) {
        return new SequencePrimitive(base, increment, exponent, length);
    }

    /** {@inheritDoc} */
    @Override
    protected Long convertValue(int value) {
        return (long) value;
    }

    /** {@inheritDoc} */
    @Override
    protected Long convertValue(long value) {
        return value;
    }

    /** {@inheritDoc} */
    @Override
    protected Long convertLength(int length) {
        return (long) length;
    }

    /** {@inheritDoc} */
    @Override
    protected Long convertLength(long length) {
        return length;
    }

}
