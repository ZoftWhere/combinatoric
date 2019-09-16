package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;

class PermutationWithValue<T extends Comparable<T>> extends AbstractPermutation<T> {

    private final int[] index;

    private final List<T> list;

    private final int size;

    PermutationWithValue(final int[] index, final List<T> list, final int size) {
        super(index);
        this.index = getIndex();
        this.list = list;
        this.size = size;
    }

    @Override
    public List<T> getValue() {
        List<T> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(getValue(i));
        }
        return result;
    }

    @Override
    public T getValue(int position) {
        return list.get(index[position]);
    }

    @Override
    public PermutationWithValue<T> next(int position) {
        if (position < 0 || position > size - 2) {
            return new PermutationWithValue<>(new int[0], null, 0);
        }

        int min = index[position];
        T minElement = list.get(index[position]);
        int max = Integer.MAX_VALUE;
        T maxElement = null;
        int swap = position;

        for (int i = position + 1; i < size; i++) {
            if (index[i] > min && getValue(i).compareTo(minElement) > 0) {
                if (index[i] < max) {
                    if (maxElement == null || (list.get(index[i]).compareTo(maxElement) <= 0)) {
                        swap = i;
                        max = index[swap];
                        maxElement = list.get(max);
                    }
                }
            }
        }

        if (swap == position) {
            return new PermutationWithValue<>(new int[0], null, 0);
        }

        final int[] push = next(index, position, swap);
        return new PermutationWithValue<>(push, list, size);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        builder.append(String.format("%d:%s", index[0], getValue(0)));
        for (int i = 1; i < size; i++) {
            builder.append(String.format(", %d:%s", index[i], getValue(i)));
        }

        return builder.append("]").toString();
    }

}
