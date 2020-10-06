package app.zoftwhere.combinatoric;

import java.math.BigInteger;
import java.util.List;

/**
 * <p>K-Tuple.
 * </p>
 * <p>K-Tuples are not permutations in general.</p>
 * <p>K-Tuples are ordered arrangements of the elements of a set where repetitions are allowed.</p>
 */
public interface KTuple<T> {

    /**
     * Check if the k-tuple has any elements.
     *
     * @return true if the k-tuple has elements, false otherwise
     * @since 3.0.0
     */
    boolean isPresent();

    /**
     * Check if the k-tuple is empty.
     *
     * @return true if the k-tuple is empty, false otherwise
     * @since 3.0.0
     */
    boolean isEmpty();

    /**
     * The element count in the selection set.
     *
     * @return element count in the selection set
     * @since 3.0.0
     */
    int size();

    /**
     * The element count in the k-tuple.
     *
     * @return element count in the k-tuple
     * @since 3.0.0
     */
    int kSize();

    /**
     * Get the index value from the k-tuple array.
     *
     * @param position index array position (zero-based)
     * @return the value for the index
     * @throws ArrayIndexOutOfBoundsException if position is out of bounds
     * @since 3.0.0
     */
    int index(int position);

    /**
     * The index array.
     *
     * @return index array
     * @since 3.0.0
     */
    int[] index();

    /**
     * Get the value of an element in the current k-tuple collection.
     *
     * @param position position of element to retrieve
     * @return the element at the position of the collection
     * @since 3.0.0
     */
    T value(int position);

    /**
     * Get the collection of the current order of the k-tuple.
     *
     * @return the collection of the current order of the k-tuple
     * @since 3.0.0
     */
    List<T> value();

    /**
     * Progress to the next available k-tuple.
     *
     * @return the next k-tuple if possible, an empty k-tuple otherwise
     * @since 3.0.0
     */
    KTuple<T> next();

    /**
     * Progress to the next available k-tuple from the position provided.
     *
     * @param position the element to change
     * @return the next k-tuple if possible, an empty k-tuple otherwise
     * @since 3.0.0
     */
    KTuple<T> next(int position);

    /**
     * Return the total number of unique k-tuples possible
     *
     * @return total number of unique k-tuples possible
     * @since 3.0.0
     */
    BigInteger count();

}
