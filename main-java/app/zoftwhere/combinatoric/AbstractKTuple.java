package app.zoftwhere.combinatoric;

import java.math.BigInteger;
import java.util.List;

/**
 * <p>Abstract Permutation.
 * </p>
 * <p>This is a package-private abstract class for generic functionality.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
abstract class AbstractKTuple<T> implements KTuple<T> {

    final int[] index;

    private final int size;

    final List<T> kSet;

    private final int kSize;

    /**
     * Package-private constructor to initialize a new k-tuple.
     *
     * @param index index array
     * @param kSet  ordered set of k-elements
     * @param kSize count of k-tuple elements
     * @since 3.0.0
     */
    AbstractKTuple(int[] index, List<T> kSet, int kSize) {
        this.index = index;
        this.size = index.length;
        this.kSet = kSet;
        this.kSize = kSize;
    }

    /**
     * Returns an immutable instance with the values in the clone.
     *
     * @param index index array
     * @param kSet  ordered set of k-elements
     * @param kSize count of k-tuple elements
     * @return immutable permutation instance.
     * @since 3.0.0
     */
    protected abstract KTuple<T> newInstance(int[] index, List<T> kSet, int kSize);

    /** {@inheritDoc} */
    @Override
    public int size() {
        return size;
    }

    /** {@inheritDoc} */
    @Override
    public int kSize() {
        return kSize;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isPresent() {
        return size != 0;
    }

    /** {@inheritDoc} */
    @Override
    public int[] index() {
        int[] copy = new int[size];
        System.arraycopy(index, 0, copy, 0, size);
        return copy;
    }

    /** {@inheritDoc} */
    @Override
    public int index(int position) {
        checkPosition(position);
        return index[position];
    }

    /** {@inheritDoc} */
    @Override
    public abstract List<T> value();

    /** {@inheritDoc} */
    @Override
    public abstract T value(int position);

    /** {@inheritDoc} */
    @Override
    public KTuple<T> next() {
        return next(size - 1);
    }

    /** {@inheritDoc} */
    @Override
    public KTuple<T> next(int position) {
        checkPosition(position);

        int[] next = advance(position);
        if (next == null) {
            return new KTupleEmpty<>();
        }
        for (int i = position + 1; i < size; i++) {
            next[i] = 0;
        }

        return newInstance(next, kSet, kSize);
    }

    /** {@inheritDoc} */
    @Override
    public BigInteger count() {
        if (size == 0 || kSize == 0) {
            return BigInteger.ZERO;
        }
        return BigInteger.valueOf(kSize).pow(size);
    }

    /**
     * Check the position.
     *
     * @param position position
     * @since 3.0.0
     */
    final void checkPosition(int position) {
        if (position < 0 || position >= size) {
            String message = "tuple.check.position.invalid.position";
            Exception cause = new Exception(String.format("size: %d position: %d", size, position));
            throw new IllegalArgumentException(message, cause);
        }
    }

    /**
     * Helper method for advancing at a give position.
     *
     * @param position the index position to advance
     * @return the index array after advancement
     * @since 3.0.0
     */
    private int[] advance(int position) {
        int[] copy = new int[size];
        System.arraycopy(index, 0, copy, 0, size);

        while (position >= 0) {
            copy[position]++;
            if (copy[position] != kSize) {
                return copy;
            }
            copy[position] = 0;
            position--;
        }

        return null;
    }

    /**
     * Returns string representation for the k-tuple.
     *
     * @return string representation for the k-tuple
     */
    @Override
    public String toString() {

        // Build string for empty k-tuple.
        if (size == 0) {
            return "[]";
        }

        // Build string for index-only k-tuple.
        else if (kSet == null) {
            StringBuilder builder = new StringBuilder("[");
            builder.append(String.format("%d", index[0]));
            for (int i = 1; i < size; i++) {
                builder.append(String.format(", %d", index[i]));
            }
            return builder.append("]").toString();
        }

        // Build string for k-set k-tuple.
        else {
            StringBuilder builder = new StringBuilder("[");
            builder.append(String.format("%d:%s", index[0], kSet.get(0)));
            for (int i = 1; i < size; i++) {
                builder.append(String.format(", %d:%s", index[i], kSet.get(index[i])));
            }
            return builder.append("]").toString();
        }
    }

}
