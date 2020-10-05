package app.zoftwhere.combinatoric;

import java.math.BigInteger;
import java.util.List;

import static app.zoftwhere.combinatoric.Generator.emptyPermutation;

/**
 * <p>Permutation N-Tuple.
 * </p>
 * <p>This is a package-private class that implements functionality.
 * </p>
 *
 * @author Osmund
 * @since 2.0.0
 */
class PermutationNTuple<T> extends PermutationBasic<T> {

    private final int[] index;

    private final List<T> list;

    private final int size;

    private final int kSize;

    /**
     * Constructor for {@link app.zoftwhere.combinatoric.PermutationNTuple} (package-private).
     *
     * @param index index
     * @param list  list
     * @param kSize size of display elements
     * @since 2.0.0
     */
    PermutationNTuple(int[] index, List<T> list, int kSize) {
        super(index, list, kSize);
        this.index = index;
        this.size = index.length;
        this.list = list;
        this.kSize = kSize;
    }

    /** {@inheritDoc} */
    @Override
    protected Permutation<T> newInstance(int[] index, List<T> list, int kSize) {
        return new PermutationNTuple<>(index, list, kSize);
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

        throw new NoSuchMethodError("kSize?");
    }

    /**
     * Private method for returning count for a simple n-tuple (k-size == size).
     *
     * @return count for simple n-tuple
     */
    private BigInteger simpleCount() {
        var group = 1;
        var compacted = 0;
        var total = BigInteger.ONE;

        var left = list.get(0);

        for (int i = 1; i < size; i++) {
            var right = list.get(i);
            if (left.equals(right)) {
                group++;
            }
            else {
                if (group != 1) {
                    var factor = Calculator.nCr(compacted + group, group);
                    total = total.multiply(factor);
                    compacted += group;
                    group = 1;
                }
            }
            left = right;
        }

        if (group > 1) {
            var factor = Calculator.nCr(compacted + group, group);
            total = total.multiply(factor);
            compacted += group;
        }

        var unique = size - compacted;

        if (unique > 0) {
            var factor = 1L;
            for (int i = 1; i <= unique; i++) {
                factor *= (compacted + i);
                if (factor > Integer.MAX_VALUE) {
                    total = total.multiply(BigInteger.valueOf(factor));
                    factor = 1;
                }
            }
            if (factor > 1) {
                total = total.multiply(BigInteger.valueOf(factor));
            }
        }

        return total;
    }

}
