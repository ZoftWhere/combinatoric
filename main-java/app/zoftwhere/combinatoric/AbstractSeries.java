package app.zoftwhere.combinatoric;

public abstract class AbstractSeries<T, L> implements Series<T, L> {

    private final T base;

    private final int exponent;

    private final T increment;

    private final L length;

    AbstractSeries(T base, T increment, int exponent, L length) {
        this.base = base;
        this.increment = increment;
        this.exponent = exponent;
        this.length = length;
    }

    @Override
    public T base() {
        return base;
    }

    @Override
    public T increment() {
        return increment;
    }

    @Override
    public int exponent() {
        return exponent;
    }

    @Override
    public L length() {
        return length;
    }

    protected abstract AbstractSeries<T, L> clone(T base, T increment, int exponent, L length);

    protected abstract T convertValue(int value);

    protected abstract T convertValue(long value);

    protected abstract L convertLength(int length);

    protected abstract L convertLength(long length);

    public AbstractSeries<T, L> base(int base) {
        return clone(convertValue(base), increment(), exponent(), length());
    }

    public AbstractSeries<T, L> base(long base) {
        return clone(convertValue(base), increment(), exponent(), length());
    }

    public AbstractSeries<T, L> base(T base) {
        return clone(base, increment(), exponent(), length());
    }

    public AbstractSeries<T, L> increment(int increment) {
        return clone(base(), convertValue(increment), exponent(), length());
    }

    public AbstractSeries<T, L> increment(long increment) {
        return clone(base(), convertValue(increment), exponent(), length());
    }

    public AbstractSeries<T, L> increment(T increment) {
        return clone(base(), increment, exponent(), length());
    }

    public AbstractSeries<T, L> exponent(int exponent) {
        return clone(base(), increment(), exponent, length());
    }

    public AbstractSeries<T, L> length(int length) {
        return clone(base(), increment(), exponent(), convertLength(length));
    }

    public AbstractSeries<T, L> length(long length) {
        return clone(base(), increment(), exponent(), convertLength(length));
    }

    public AbstractSeries<T, L> length(L length) {
        return clone(base(), increment(), exponent(), length);
    }

}
