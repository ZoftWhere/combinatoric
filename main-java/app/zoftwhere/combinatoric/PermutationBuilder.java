package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public abstract class PermutationBuilder {

    /**
     * Creates an immutable index permutation.
     *
     * @param size the number of elements to hold.
     * @return immutable index permutation
     */
    public static AbstractPermutation<Void> create(int size) {
        if (size < 1) {
            return new PermutationEmpty<>();
        }

        return new PermutationBasic<>(orderedArray(size), size);
    }

    /**
     * Creates an immutable index permutation.
     *
     * @param list the value elements to hold.
     * @return immutable index permutation
     */
    public static <T extends Comparable<T>> AbstractPermutation<T> create(List<T> list) {
        if (list == null || list.size() == 0) {
            return new PermutationEmpty<>();
        }

        final int size = list.size();
        final List<T> sortedList = new ArrayList<>(size);
        sortedList.addAll(list);
        sortedList.sort(Comparator.naturalOrder());

        return new PermutationWithValue<>(orderedArray(size), unmodifiableList(sortedList), size);
    }

    /**
     * Creates an empty permutation.
     *
     * @return an empty permutation
     */
    static AbstractPermutation<Integer> empty() {
        return new PermutationEmpty<>();
    }

    /**
     * Creates an ordered index array for the permutation.
     *
     * @param size the size of the array
     * @return an ordered index array
     */
    private static int[] orderedArray(int size) {
        final int[] index = new int[size];
        for (int i = 0; i < size; i++) {
            index[i] = i;
        }
        return index;
    }

}
