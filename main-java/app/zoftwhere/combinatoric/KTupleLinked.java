package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>K-Tuple Full.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
public class KTupleLinked<T> extends AbstractKTuple<T> {

    /**
     * Package-private constructor to initialize a new k-tuple.
     *
     * @param index index array
     * @param kSet  ordered set of k-elements
     * @param kSize count of k-tuple elements
     * @since 3.0.0
     */
    KTupleLinked(int[] index, List<T> kSet, int kSize) {
        super(index, kSet, kSize);
    }

    /** {@inheritDoc} */
    @Override
    protected KTuple<T> newInstance(int[] index, List<T> kSet, int kSize) {
        return new KTupleLinked<>(index, kSet, kSize);
    }

    /** {@inheritDoc} */
    @Override
    public List<T> value() {
        Objects.requireNonNull(kSet, "tuple.set.null");
        return new ArrayList<>(kSet);
    }

    /** {@inheritDoc} */
    @Override
    public T value(int position) {
        Objects.requireNonNull(kSet, "tuple.set.null");
        checkPosition(position);
        return kSet.get(index[position]);
    }

}
