package app.zoftwhere.combinatoric;

import java.util.List;
import java.util.NoSuchElementException;

class PermutationBasic<T> extends AbstractPermutation<T> {

    private final int size;

    private final int[] index;

    PermutationBasic(int[] index, int size) {
        super(index);
        this.index = getIndex();
        this.size = size;
    }

    @Override
    public List<T> getValue() {
        return null;
    }

    @Override
    public T getValue(int position) {
        throw new NoSuchElementException();
    }


    @Override
    public PermutationBasic<T> next(int position) {
        if (position < 0 || position >= size) {
            return new PermutationBasic<>(new int[0], 0);
        }

        int min = index[position];
        int max = Integer.MAX_VALUE;
        int swap = position;

        for (int i = position + 1; i < size; i++) {
            if (index[i] == min + 1) {
                int[] push = next(index, position, i);
                return new PermutationBasic<>(push, size);
            }
            if (index[i] > min && index[i] < max) {
                swap = i;
                max = index[i];
            }
        }

        if (swap == position) {
            return new PermutationBasic<>(new int[0], 0);
        }

        return new PermutationBasic<>(next(index, position, swap), size);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        builder.append(String.format("%d", index[0]));
        for (int i = 1; i < size; i++) {
            builder.append(String.format(", %d", index[i]));
        }

        return builder.append("]").toString();
    }

}
