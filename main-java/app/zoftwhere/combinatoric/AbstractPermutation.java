package app.zoftwhere.combinatoric;

import java.util.Arrays;
import java.util.List;

import static app.zoftwhere.combinatoric.Generator.empty;

abstract class AbstractPermutation<T> implements Permutation<T> {

    private final int[] index;

    private final int size;

    private final int kSize;

    /**
     * Package-private constructor to initialize a new permutation.
     *
     * @param index index array
     * @param kSize count of permutation elements
     */
    AbstractPermutation(int[] index, int kSize) {
        this.index = index;
        this.size = index.length;
        this.kSize = kSize;
    }

    /**
     * Returns an immutable instance with the values in the clone.
     *
     * @param index index array
     * @param list  list of elements
     * @param kSize count of permutation elements
     * @return immutable permutation instance.
     */
    protected abstract Permutation<T> newInstance(int[] index, List<T> list, int kSize);

    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    public int kSize() {
        return kSize;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPresent() {
        return size != 0;
    }

    /**
     * {@inheritDoc}
     */
    public int[] index() {
        int[] push = new int[size];
        System.arraycopy(index, 0, push, 0, size);
        return push;
    }

    /**
     * {@inheritDoc}
     */
    public int index(int position) {
        return index[position];
    }

    /**
     * {@inheritDoc}
     */
    public abstract List<T> value();

    /**
     * {@inheritDoc}
     */
    public abstract T value(int position);

    /**
     * {@inheritDoc}
     */
    public Permutation<T> next() {
        if (size < 2) {
            return empty();
        }
        return next(Math.min(size - 2, kSize - 1));
    }

    /**
     * {@inheritDoc}
     */
    public Permutation<T> next(int position) {
        checkPosition(position);

        int current = Math.min(position, kSize - 1);
        Permutation<T> next;

        while (current >= 0) {
            next = progress(current);
            current--;

            if (next.isPresent()) {
                return next;
            }
        }

        return progress(0);
    }

    /**
     * {@inheritDoc}
     */
    public abstract Permutation<T> progress(int position);

    boolean checkPosition(int position) {
        if (position < 0 || position >= size) {
            final var template = "Index %d out of bounds for length %d";
            throw new ArrayIndexOutOfBoundsException(String.format(template, position, size));
        }

        return (position < size - 1) && (position < kSize);
    }

    /**
     * Helper method for advancing at a give index, and resetting (sorting) trailing positions.
     *
     * @param index the index array to advance
     * @param left  the index position to advance
     * @param right the replacement position index array index
     * @return the index array after advancement
     */
    int[] advance(int[] index, int left, int right) {
        int[] push = new int[size];
        System.arraycopy(index, 0, push, 0, size);
        push[left] = index[right];
        push[right] = index[left];
        Arrays.sort(push, left + 1, size);
        return push;
    }

    /**
     * Creates an ordered index array for the permutation.
     *
     * @param size the size of the array
     * @return an ordered index array
     */
    static int[] orderedArray(int size) {
        final int[] index = new int[size];
        for (int i = 0; i < size; i++) {
            index[i] = i;
        }
        return index;
    }

}
