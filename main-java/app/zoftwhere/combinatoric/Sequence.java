package app.zoftwhere.combinatoric;

/**
 * Defines the polynomial int the form P(x) = sum{i=0..n-1} (a + dx)^p .
 *
 * @param <T> The type for base (a) and increment (d)
 * @param <L> The type for the length (n)
 */
public interface Sequence<T, L> {

    T base();

    int exponent();

    T increment();

    L length();

    T sum();

    Sequence<T, L> base(int base);

    Sequence<T, L> base(long base);

    Sequence<T, L> base(T base);

    Sequence<T, L> increment(int increment);

    Sequence<T, L> increment(long increment);

    Sequence<T, L> increment(T increment);

    Sequence<T, L> exponent(int exponent);

    Sequence<T, L> length(int length);

    Sequence<T, L> length(long length);

    Sequence<T, L> length(L length);

}
