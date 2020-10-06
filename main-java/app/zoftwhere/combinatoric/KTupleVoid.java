package app.zoftwhere.combinatoric;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>K-Tuple Void.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
public class KTupleVoid extends KTupleLinked<Void> {

    /**
     * Package-private constructor to initialize an index-only k-tuple.
     *
     * @param index index array
     * @param kSize count of k-tuple elements
     * @since 3.0.0
     */
    KTupleVoid(int[] index, int kSize) {
        super(index, null, kSize);
    }

    /** {@inheritDoc} */
    @Override
    protected KTuple<Void> newInstance(int[] index, List<Void> list, int kSize) {
        return new KTupleVoid(index, kSize);
    }

    /** {@inheritDoc} */
    @Override
    public List<Void> value() {
        throw new NoSuchElementException("tuple.empty.no.index");
    }

    /** {@inheritDoc} */
    @Override
    public Void value(int position) {
        throw new NoSuchElementException("tuple.empty.no.index");
    }

}
