package app.zoftwhere.combinatoric;

/**
 * <p>Abstract Sequence.
 * </p>
 *
 * @author Osmund
 */
abstract class AbstractSequence<T, L> implements Sequence<T, L>, Cloneable {

    /** base value */
    private final T base;

    /** increment value */
    private final T increment;

    /** exponent value */
    private final int exponent;

    /** sequence length */
    private final L length;

    /**
     * Constructor for {@link app.zoftwhere.combinatoric.AbstractSequence} (package-private).
     *
     * @param base      base value
     * @param increment increment value
     * @param exponent  exponent value
     * @param length    sequence length
     */
    AbstractSequence(T base, T increment, int exponent, L length) {
        this.base = base;
        this.increment = increment;
        this.exponent = exponent;
        this.length = length;
    }

    /** {@inheritDoc} */
    @Override
    public T base() {
        return base;
    }

    /** {@inheritDoc} */
    @Override
    public T increment() {
        return increment;
    }

    /** {@inheritDoc} */
    @Override
    public int exponent() {
        return exponent;
    }

    /** {@inheritDoc} */
    @Override
    public L length() {
        return length;
    }

    /** {@inheritDoc} */
    @Override
    public abstract T sum();

    /**
     * Returns an immutable instance with the values in the clone.
     *
     * @param base      base value
     * @param increment increment value
     * @param exponent  exponent value
     * @param length    sequence length
     * @return immutable instance
     */
    protected abstract Sequence<T, L> newInstance(T base, T increment, int exponent, L length);

    /**
     * @param value the value to convert
     * @return the converted value of type <code>T</code>
     */
    protected abstract T convertValue(int value);

    /**
     * @param value the value to convert
     * @return the converted value of type <code>T</code>
     */
    protected abstract T convertValue(long value);

    /**
     * @param length the value to convert
     * @return the converted value of type <code>L</code>
     */
    protected abstract L convertLength(int length);

    /**
     * @param length the value to convert
     * @return the converted value of type <code>L</code>
     */
    protected abstract L convertLength(long length);

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> base(int base) {
        return newInstance(convertValue(base), increment(), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> base(long base) {
        return newInstance(convertValue(base), increment(), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> base(T base) {
        return newInstance(base, increment(), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> increment(int increment) {
        return newInstance(base(), convertValue(increment), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> increment(long increment) {
        return newInstance(base(), convertValue(increment), exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> increment(T increment) {
        return newInstance(base(), increment, exponent(), length());
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> exponent(int exponent) {
        return newInstance(base(), increment(), exponent, length());
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> length(int length) {
        return newInstance(base(), increment(), exponent(), convertLength(length));
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> length(long length) {
        return newInstance(base(), increment(), exponent(), convertLength(length));
    }

    /** {@inheritDoc} */
    @Override
    public Sequence<T, L> length(L length) {
        return newInstance(base(), increment(), exponent(), length);
    }

}
