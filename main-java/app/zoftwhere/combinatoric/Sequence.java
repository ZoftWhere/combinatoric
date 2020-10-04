package app.zoftwhere.combinatoric;

/**
 * Defines the polynomial int the form P(x) = sum{i=0..n-1} (a + dx)^p .
 *
 * @param <T> The type for base (a) and increment (d)
 * @param <L> The type for the length (n)
 */
public interface Sequence<T, L> {

    /**
     * Return the base value.
     *
     * @return base value
     */
    T base();

    /**
     * Return the exponent value.
     *
     * @return exponent value
     */
    int exponent();

    /**
     * Return the increment value.
     *
     * @return increment value
     */
    T increment();

    /**
     * Return the sequence length.
     *
     * @return sequence length
     */
    L length();

    /**
     * Calculate the sum of the sequence
     *
     * @return series value
     */
    T sum();

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     */
    Sequence<T, L> base(int base);

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     */
    Sequence<T, L> base(long base);

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     */
    Sequence<T, L> base(T base);

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     */
    Sequence<T, L> increment(int increment);

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     */
    Sequence<T, L> increment(long increment);

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     */
    Sequence<T, L> increment(T increment);

    /**
     * Create a sequence, based on the current, with a different exponent value.
     *
     * @param exponent the increment value
     * @return a new immutable instance with the new exponent
     */
    Sequence<T, L> exponent(int exponent);

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     */
    Sequence<T, L> length(int length);

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     */
    Sequence<T, L> length(long length);

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     */
    Sequence<T, L> length(L length);

}
