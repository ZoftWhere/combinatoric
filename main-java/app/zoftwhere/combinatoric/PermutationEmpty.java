package app.zoftwhere.combinatoric;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>Permutation Empty.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
 * @since 1.0.0
 */
class PermutationEmpty<T> extends AbstractPermutation<T> {

    /**
     * Constructor for {@link app.zoftwhere.combinatoric.PermutationEmpty} (package-private).
     */
    PermutationEmpty() {
        super(new int[0], 0);
    }

    /** {@inheritDoc} */
    @Override
    protected Permutation<T> newInstance(int[] index, List<T> list, int kSize) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public int[] index() {
        throw new NoSuchElementException("permutation.empty.no.index");
    }

    /** {@inheritDoc} */
    @Override
    public int index(int position) {
        throw new NoSuchElementException("permutation.empty.no.index");
    }

    /** {@inheritDoc} */
    @Override
    public List<T> value() {
        throw new NoSuchElementException("permutation.empty.no.value");
    }

    /** {@inheritDoc} */
    @Override
    public T value(int position) {
        throw new NoSuchElementException("permutation.empty.no.value");
    }

    /**
     * Returns an empty permutation.
     *
     * @return empty permutation
     * @since 2.0.0
     */
    @Override
    public Permutation<T> next() {
        return this;
    }

    /**
     * Returns an empty permutation.
     *
     * @param position ignored
     * @return empty permutation
     * @since 2.0.0
     */
    @Override
    public Permutation<T> next(int position) {
        return this;
    }

    /**
     * Returns an empty permutation.
     *
     * @param position ignored
     * @return empty permutation
     * @since 2.0.0
     */
    @Override
    public Permutation<T> progress(int position) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BigInteger count() {
        return BigInteger.ZERO;
    }

    /**
     * Returns the empty permutation string.
     *
     * @return empty permutation string
     * @since 2.0.0
     */
    @Override
    public String toString() {
        return "[]";
    }

}
