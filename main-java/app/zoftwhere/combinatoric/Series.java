package app.zoftwhere.combinatoric;

public interface Series<T, L> {

    T base();

    int exponent();

    T increment();

    L length();

}
