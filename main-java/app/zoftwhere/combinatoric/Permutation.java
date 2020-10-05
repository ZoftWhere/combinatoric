package app.zoftwhere.combinatoric;

import java.util.List;

/**
 * Permutation.
 *
 * @param <T> the type
 * @since 2.0.0
 */
public interface Permutation<T> {

    /**
     * Check if the permutation has any elements.
     *
     * @return true if the permutation has elements, false otherwise
     * @since 2.0.0
     */
    boolean isPresent();

    /**
     * Check if the permutation is empty.
     *
     * @return true if the permutation is empty, false otherwise
     * @since 2.0.0
     */
    boolean isEmpty();

    /**
     * The element count in the selection set.
     *
     * @return element count in the selection set
     * @since 2.0.0
     */
    int size();

    /**
     * The element count in the permutation.
     *
     * @return element count in the permutation
     * @since 2.0.0
     */
    int kSize();

    /**
     * Get the index value from the permutation array.
     *
     * @param position index array position (zero-based)
     * @return the value for the index
     * @throws ArrayIndexOutOfBoundsException if position is out of bounds
     * @since 2.0.0
     */
    int index(int position);

    /**
     * The index array.
     *
     * @return index array
     * @since 2.0.0
     */
    int[] index();

    /**
     * Get the value of an element in the current permutation collection.
     *
     * @param position position of element to retrieve
     * @return the element at the position of the collection
     * @since 2.0.0
     */
    T value(int position);

    /**
     * Get the collection of the current order of the permutation.
     *
     * @return the collection of the current order of the permutation
     * @since 2.0.0
     */
    List<T> value();

    /**
     * Progress to the next available permutation.
     *
     * @return the next permutation if possible, an empty permutation otherwise
     * @since 2.0.0
     */
    Permutation<T> next();

    /**
     * Progress to the next available permutation from the position provided.
     *
     * @param position the element to change
     * @return the next permutation if possible, an empty permutation otherwise
     * @since 2.0.0
     */
    Permutation<T> next(int position);

    /**
     * Progress to the permutation with element at position changed.
     *
     * @param position the element to change
     * @return the next permutation if possible, an empty permutation otherwise
     * @since 2.0.0
     */
    Permutation<T> progress(int position);

}
