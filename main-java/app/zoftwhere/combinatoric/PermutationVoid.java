package app.zoftwhere.combinatoric;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>Permutation Void.
 * </p>
 * <p>The Permutation Void class is an index-only implementation.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
 * @since 2.0.0
 */
class PermutationVoid extends PermutationBasic<Void> {

    /**
     * Constructor for {@link app.zoftwhere.combinatoric.PermutationVoid} (package-private).
     *
     * @param index index
     * @param kSize size of display elements
     * @since 2.0.0
     */
    PermutationVoid(int[] index, int kSize) {
        super(index, null, kSize);
    }

    /** {@inheritDoc} */
    @Override
    protected Permutation<Void> newInstance(int[] index, List<Void> list, int kSize) {
        return new PermutationVoid(index, kSize);
    }

    /** {@inheritDoc} */
    @Override
    public List<Void> value() {
        throw new NoSuchElementException();
    }

    /** {@inheritDoc} */
    @Override
    public Void value(int position) {
        throw new NoSuchElementException();
    }

    /**
     * Returns the permutation index information.
     *
     * @return permutation index information
     * @since 2.0.0
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(String.format("%d", index[0]));
        for (int i = 1; i < kSize; i++) {
            builder.append(String.format(", %d", index[i]));
        }
        if (kSize < size) {
            builder.append(String.format("][%d", index[kSize]));
        }
        for (int i = kSize + 1; i < size; i++) {
            builder.append(String.format(", %d", index[i]));
        }

        return builder.append("]").toString();
    }

}
