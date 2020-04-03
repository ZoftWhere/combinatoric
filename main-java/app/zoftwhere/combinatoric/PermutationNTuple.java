package app.zoftwhere.combinatoric;

import java.util.List;

import static app.zoftwhere.combinatoric.Generator.empty;

class PermutationNTuple<T> extends PermutationBasic<T> {

    private final int[] index;

    private final List<T> list;

    private final int size;

    private final int kSize;

    PermutationNTuple(int[] index, List<T> list, int kSize) {
        super(index, list, kSize);
        this.index = index;
        this.size = index.length;
        this.list = list;
        this.kSize = kSize;
    }

    @Override
    protected Permutation<T> newInstance(int[] index, List<T> list, int kSize) {
        return new PermutationNTuple<>(index, list, kSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Permutation<T> progress(int position) {
        if (!checkPosition(position)) {
            return empty();
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
            return empty();
        }

        final int[] push = advance(index, position, swap);
        return newInstance(push, list, kSize);
    }

}
