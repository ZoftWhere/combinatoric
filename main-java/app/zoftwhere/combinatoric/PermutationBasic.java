package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;

import static app.zoftwhere.combinatoric.Generator.emptyPermutation;

/**
 * <p>Permutation Basic.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
 */
class PermutationBasic<T> extends AbstractPermutation<T> {

    private final int size;

    private final int[] index;

    private final List<T> list;

    private final int kSize;

    /**
     * Constructor for {@link app.zoftwhere.combinatoric.PermutationBasic} (package-private).
     *
     * @param index index
     * @param list  list
     * @param kSize size of display elements
     */
    PermutationBasic(int[] index, List<T> list, int kSize) {
        super(index, kSize);
        this.index = index;
        this.size = index.length;
        this.list = list;
        this.kSize = kSize;
    }

    /** {@inheritDoc} */
    @Override
    protected Permutation<T> newInstance(int[] index, List<T> list, int kSize) {
        return new PermutationBasic<>(index, list, kSize);
    }

    /** {@inheritDoc} */
    @Override
    public List<T> value() {
        List<T> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(value(i));
        }
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public T value(int position) {
        return list.get(index[position]);
    }

    /** {@inheritDoc} */
    @Override
    public Permutation<T> progress(int position) {
        if (!checkPosition(position)) {
            return emptyPermutation();
        }

        int min = index[position];
        int max = Integer.MAX_VALUE;
        int swap = position;

        for (int i = position + 1; i < size; i++) {
            if (index[i] == min + 1) {
                int[] push = advance(index, position, i);
                return newInstance(push, list, kSize);
            }
            if (index[i] > min && index[i] < max) {
                swap = i;
                max = index[i];
            }
        }

        if (swap == position) {
            return emptyPermutation();
        }

        return newInstance(advance(index, position, swap), list, kSize);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(String.format("%d:%s", index[0], value(0)));
        for (int i = 1; i < kSize; i++) {
            builder.append(String.format(", %d:%s", index[i], value(i)));
        }
        if (kSize < size) {
            builder.append(String.format("][%d:%s", index[kSize], value(kSize)));
        }
        for (int i = kSize + 1; i < size; i++) {
            builder.append(String.format(", %d:%s", index[i], value(i)));
        }

        return builder.append("]").toString();
    }

}
