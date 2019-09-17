package app.zoftwhere.combinatoric;

abstract class AbstractSequence<T, L> implements Sequence<T, L>, Cloneable {

    private final T base;

    private final int exponent;

    private final T increment;

    private final L length;

    AbstractSequence(T base, T increment, int exponent, L length) {
        this.base = base;
        this.increment = increment;
        this.exponent = exponent;
        this.length = length;
    }

    public T base() {
        return base;
    }

    public T increment() {
        return increment;
    }

    public int exponent() {
        return exponent;
    }

    public L length() {
        return length;
    }

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

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     */
    public Sequence<T, L> base(int base) {
        return newInstance(convertValue(base), increment(), exponent(), length());
    }

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     */
    public Sequence<T, L> base(long base) {
        return newInstance(convertValue(base), increment(), exponent(), length());
    }

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     */
    public Sequence<T, L> base(T base) {
        return newInstance(base, increment(), exponent(), length());
    }

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     */
    public Sequence<T, L> increment(int increment) {
        return newInstance(base(), convertValue(increment), exponent(), length());
    }

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     */
    public Sequence<T, L> increment(long increment) {
        return newInstance(base(), convertValue(increment), exponent(), length());
    }

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     */
    public Sequence<T, L> increment(T increment) {
        return newInstance(base(), increment, exponent(), length());
    }

    /**
     * Create a sequence, based on the current, with a different exponent value.
     *
     * @param exponent the increment value
     * @return a new immutable instance with the new exponent
     */
    public Sequence<T, L> exponent(int exponent) {
        return newInstance(base(), increment(), exponent, length());
    }

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     */
    public Sequence<T, L> length(int length) {
        return newInstance(base(), increment(), exponent(), convertLength(length));
    }

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     */
    public Sequence<T, L> length(long length) {
        return newInstance(base(), increment(), exponent(), convertLength(length));
    }

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     */
    public Sequence<T, L> length(L length) {
        return newInstance(base(), increment(), exponent(), length);
    }

}
