package app.zoftwhere.combinatoric;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>Permutation Empty.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
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
        throw new NoSuchElementException();
    }

    /** {@inheritDoc} */
    @Override
    public int index(int position) {
        throw new NoSuchElementException();
    }

    /** {@inheritDoc} */
    @Override
    public List<T> value() {
        throw new NoSuchElementException();
    }

    /** {@inheritDoc} */
    @Override
    public T value(int position) {
        throw new NoSuchElementException();
    }

    /**
     * Returns an empty permutation.
     *
     * @return empty permutation
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
     */
    @Override
    public Permutation<T> progress(int position) {
        return this;
    }

    @Override
    public String toString() {
        return "[]";
    }

}
