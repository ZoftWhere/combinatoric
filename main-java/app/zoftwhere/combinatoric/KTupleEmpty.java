package app.zoftwhere.combinatoric;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>K-Tuple Empty.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
public class KTupleEmpty<T> extends AbstractKTuple<T> {

    /**
     * Package-private constructor to initialize an empty k-tuple.
     *
     * @since 3.0.0
     */
    KTupleEmpty() {
        super(new int[0], null, 0);
    }

    /** {@inheritDoc} */
    @Override
    protected KTuple<T> newInstance(int[] index, List<T> kSet, int kSize) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public List<T> value() {
        throw new NoSuchElementException("tuple.empty.no.index");
    }

    /** {@inheritDoc} */
    @Override
    public T value(int position) {
        throw new NoSuchElementException("tuple.empty.no.index");
    }

    /**
     * Returns an empty permutation.
     *
     * @return empty permutation
     * @since 2.0.0
     */
    @Override
    public KTuple<T> next() {
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
    public KTuple<T> next(int position) {
        return this;
    }

}
