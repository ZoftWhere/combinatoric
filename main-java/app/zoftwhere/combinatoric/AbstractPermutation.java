package app.zoftwhere.combinatoric;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractPermutation<T> {

    private final int[] index;

    private final int size;

    /**
     * User PermutationBuilder to initialize a new permutation.
     *
     * @param index the index array for permutations.
     */
    AbstractPermutation(int[] index) {
        this.index = index;
        this.size = index.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isPresent() {
        return size != 0;
    }

    public int[] getIndex() {
        int[] push = new int[size];
        System.arraycopy(index, 0, push, 0, size);
        return push;
    }

    public int getIndex(int position) {
        return index[position];
    }

    public abstract List<T> getValue();

    public abstract T getValue(int position);

    public abstract AbstractPermutation<T> next(int position);

    /**
     * Helper method for advancing at a give index, and resetting (sorting) trailing positions.
     *
     * @param index the index array to advance
     * @param left  the index position to advance
     * @param right the replacement position index array index
     * @return the index array after advancement
     */
    int[] next(int[] index, int left, int right) {
        int[] push = new int[size];
        System.arraycopy(index, 0, push, 0, size);
        push[left] = index[right];
        push[right] = index[left];
        Arrays.sort(push, left + 1, size);
        return push;
    }

}
