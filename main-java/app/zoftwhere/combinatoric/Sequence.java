package app.zoftwhere.combinatoric;

/**
 * <p>Sequence.
 * </p>
 * <p>Public interface for defining finite sequences in the form:
 * </p>
 * <p><code>S = {(a)^p, (a + d)^p, ..., (a + (n-1)d)^p}</code>
 * </p>
 *
 * @param <T> The type for base (a) and increment (d)
 * @param <L> The type for the length (n)
 * @author Osmund
 * @since 2.0.0
 */
public interface Sequence<T, L> {

    /**
     * Return the base value.
     *
     * @return base value
     * @since 2.0.0
     */
    T base();

    /**
     * Return the exponent value.
     *
     * @return exponent value
     * @since 2.0.0
     */
    int exponent();

    /**
     * Return the increment value.
     *
     * @return increment value
     * @since 2.0.0
     */
    T increment();

    /**
     * Return the sequence length.
     *
     * @return sequence length
     * @since 2.0.0
     */
    L length();

    /**
     * Calculate the sum of the sequence
     *
     * @return series value
     * @since 2.0.0
     */
    T sum();

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     * @since 2.0.0
     */
    Sequence<T, L> base(int base);

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     * @since 2.0.0
     */
    Sequence<T, L> base(long base);

    /**
     * Create a sequence, based on the current, with a different base value.
     *
     * @param base the base value
     * @return a new immutable instance with the new base
     * @since 2.0.0
     */
    Sequence<T, L> base(T base);

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     * @since 2.0.0
     */
    Sequence<T, L> increment(int increment);

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     * @since 2.0.0
     */
    Sequence<T, L> increment(long increment);

    /**
     * Create a sequence, based on the current, with a different increment value.
     *
     * @param increment the increment value
     * @return a new immutable instance with the new increment
     * @since 2.0.0
     */
    Sequence<T, L> increment(T increment);

    /**
     * Create a sequence, based on the current, with a different exponent value.
     *
     * @param exponent the increment value
     * @return a new immutable instance with the new exponent
     * @since 2.0.0
     */
    Sequence<T, L> exponent(int exponent);

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     * @since 2.0.0
     */
    Sequence<T, L> length(int length);

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     * @since 2.0.0
     */
    Sequence<T, L> length(long length);

    /**
     * Create a sequence, based on the current, with a different length.
     *
     * @param length the increment value
     * @return a new immutable instance with the new length
     * @since 2.0.0
     */
    Sequence<T, L> length(L length);

}
