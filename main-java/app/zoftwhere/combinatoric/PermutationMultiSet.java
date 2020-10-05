package app.zoftwhere.combinatoric;

import java.math.BigInteger;
import java.util.List;

import static app.zoftwhere.combinatoric.Generator.emptyPermutation;

/**
 * <p>Permutation Multi-Set.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 * <p>A multi-set permutation is a permutation over a finite multi-set.  This may include a k-permutation.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
class PermutationMultiSet<T> extends PermutationBasic<T> {

    private final int[] index;

    private final List<T> list;

    private final int size;

    private final int kSize;

    /**
     * Constructor for {@link PermutationMultiSet} (package-private).
     *
     * @param index index
     * @param list  list
     * @param kSize size of display elements
     * @since 2.0.0
     */
    PermutationMultiSet(int[] index, List<T> list, int kSize) {
        super(index, list, kSize);
        this.index = index;
        this.size = index.length;
        this.list = list;
        this.kSize = kSize;
    }

    /** {@inheritDoc} */
    @Override
    protected Permutation<T> newInstance(int[] index, List<T> list, int kSize) {
        return new PermutationMultiSet<>(index, list, kSize);
    }

    /** {@inheritDoc} */
    @Override
    public Permutation<T> progress(int position) {
        if (!checkPosition(position)) {
            return emptyPermutation();
        }

        int min = index[position];
        T minElement = list.get(index[position]);
        int max = Integer.MAX_VALUE;
        T maxElement = null;
        int swap = position;

        for (int i = position + 1; i < size; i++) {
            if (index[i] > min && !value(i).equals(minElement)) {
                if (index[i] < max) {
                    if (maxElement == null || !(value(i).equals(maxElement))) {
                        swap = i;
                        max = index[swap];
                        maxElement = list.get(max);
                    }
                }
            }
        }

        if (swap == position) {
            return emptyPermutation();
        }

        final int[] push = advance(index, position, swap);
        return newInstance(push, list, kSize);
    }

    /** {@inheritDoc} */
    @Override
    public BigInteger count() {
        if (size == kSize) {
            return simpleCount();
        }

        // Cannot calculate k-permutation of multi-set permutation.
        String message = "permutation.multiset.k.permutation.count";
        Exception cause = new Exception("kSize: " + kSize);
        throw new IllegalArgumentException(message, cause);
    }

    /**
     * Private method for returning count for a multi-set permutation.
     *
     * @return count for simple multi-set permutation.
     */
    private BigInteger simpleCount() {
        int group = 1;
        int compacted = 0;
        BigInteger total = BigInteger.ONE;

        T left = list.get(0);

        for (int i = 1; i < size; i++) {
            T right = list.get(i);
            if (left.equals(right)) {
                group++;
            }
            else {
                if (group != 1) {
                    BigInteger factor = Calculator.nCr(compacted + group, group);
                    total = total.multiply(factor);
                    compacted += group;
                    group = 1;
                }
            }
            left = right;
        }

        if (group > 1) {
            BigInteger factor = Calculator.nCr(compacted + group, group);
            total = total.multiply(factor);
            compacted += group;
        }

        int unique = size - compacted;

        if (unique > 0) {
            // nPk(compacted + unique, unique) == nPk(size, unique)
            total = total.multiply(Calculator.nPk(size, unique));
        }

        return total;
    }

}
