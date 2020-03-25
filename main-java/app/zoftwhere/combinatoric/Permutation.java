package app.zoftwhere.combinatoric;

import java.util.List;

public interface Permutation<T> {

    /**
     * Check if the permutation has any elements.
     *
     * @return true if the permutation has elements, false otherwise
     */
    boolean isPresent();

    /**
     * Check if the permutation is empty.
     *
     * @return true if the permutation is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * The element count in the selection set.
     *
     * @return element count in the selection set
     */
    int size();

    /**
     * The element count in the permutation.
     *
     * @return element count in the permutation
     */
    int kSize();

    /**
     * Get the index value from the permutation array.
     *
     * @param position index array position (zero-based)
     * @return the value for the index
     * @throws ArrayIndexOutOfBoundsException if position is out of bounds
     */
    int index(int position);

    int[] index();

    T value(int position);

    List<T> value();

    /**
     * Progress to the next available permutation.
     *
     * @return the next permutation if possible, an empty permutation otherwise
     */
    Permutation<T> next();

    /**
     * Progress to the next available permutation from the position provided.
     *
     * @param position the element to change
     * @return the next permutation if possible, an empty permutation otherwise
     */
    Permutation<T> next(int position);

    /**
     * Progress to the permutation with element at position changed.
     *
     * @param position the element to change
     * @return the next permutation if possible, an empty permutation otherwise
     */
    Permutation<T> progress(int position);

}
