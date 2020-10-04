package app.zoftwhere.combinatoric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static app.zoftwhere.combinatoric.AbstractPermutation.orderedArray;
import static java.util.Collections.unmodifiableList;

/**
 * <p>Generator.
 * </p>
 * <p>This is a public class for factory functionality.
 * </p>
 *
 * @author Osmund
 * @since 2.0.0
 */
public class Generator {

    /**
     * Factory method for {@link java.lang.Long} {@link app.zoftwhere.combinatoric.Sequence}.
     *
     * @return Long sequence
     * @since 2.0.0
     */
    public static Sequence<Long, Long> primitiveSequence() {
        Long base = 1L;
        Long increment = 1L;
        int exponent = 1;
        Long length = 1L;
        return new SequencePrimitive(base, increment, exponent, length);
    }

    /**
     * Factory method for {@link java.math.BigInteger} {@link app.zoftwhere.combinatoric.Sequence}.
     *
     * @return BigInteger sequence
     * @since 2.0.0
     */
    public static Sequence<BigInteger, BigInteger> bigIntegerSequence() {
        BigInteger base = BigInteger.ONE;
        BigInteger increment = BigInteger.ONE;
        int exponent = 1;
        BigInteger length = BigInteger.ONE;
        return new SequenceBigInteger(base, increment, exponent, length);
    }

    /**
     * Factory method for {@link java.math.BigDecimal} {@link app.zoftwhere.combinatoric.Sequence}.
     *
     * @return BigDecimal sequence
     * @since 2.0.0
     */
    public static Sequence<BigDecimal, BigInteger> bigDecimalSequence() {
        BigDecimal base = BigDecimal.ONE;
        BigDecimal increment = BigDecimal.ONE;
        int exponent = 1;
        BigInteger length = BigInteger.ONE;
        return new SequenceBigDecimal(base, increment, exponent, length);
    }

    /**
     * Creates an empty permutation.
     *
     * @param <T> the type
     * @return an empty permutation
     * @since 3.0.0
     */
    public static <T> Permutation<T> emptyPermutation() {
        return new PermutationEmpty<>();
    }

    /**
     * Creates an immutable void permutation.
     *
     * @param size the number of elements to hold.
     * @return immutable void permutation
     * @since 2.0.0
     */
    public static Permutation<Void> newPermutation(int size) {
        // @since 3.0.0
        if (size < 0) {
            final String message = "generator.permutation.size.negative";
            final Exception cause = new Exception("size: " + size);
            throw new IllegalArgumentException(message, cause);
        }

        if (size == 0) {
            return emptyPermutation();
        }

        return new PermutationVoid(orderedArray(size), size);
    }

    /**
     * Creates an immutable void permutation.
     *
     * @param size  the number of elements to hold
     * @param kSize the number of elements for display
     * @return immutable void permutation
     * @since 2.0.0
     */
    public static Permutation<Void> newPermutation(int size, int kSize) {
        // @since 3.0.0
        if (size < 0) {
            final String message = "generator.permutation.size.negative";
            final Exception cause = new Exception("size: " + size);
            throw new IllegalArgumentException(message, cause);
        }

        // @since 3.0.0
        if (size < kSize) {
            final String message = "generator.permutation.out.of.bounds";
            final Exception cause = new Exception("kSize: " + kSize);
            throw new IllegalArgumentException(message, cause);
        }

        if (size == 0 || kSize == 0) {
            return emptyPermutation();
        }

        return new PermutationVoid(orderedArray(size), kSize);
    }

    /**
     * Creates an immutable linked permutation.
     *
     * @param <T>        the type
     * @param list       the value elements
     * @param comparator the comparator
     * @return immutable basic permutation if no duplicates are detected, an N-Tuple otherwise
     * @throws NullPointerException if any of the list items are null
     * @since 2.0.0
     */
    public static <T> Permutation<T> newPermutation(List<T> list, Comparator<T> comparator) {
        return newPermutation(list, comparator, list != null ? list.size() : 0);
    }

    /**
     * Creates an immutable k-permutation.
     *
     * @param <T>        the type
     * @param list       the value elements
     * @param comparator the comparator
     * @param kSize      kSize value
     * @return immutable basic permutation if no duplicates are detected, an N-Tuple otherwise
     * @throws NullPointerException if any of the list items are null
     * @since 2.0.0
     */
    public static <T> Permutation<T> newPermutation(List<T> list, Comparator<T> comparator, int kSize) {
        final int size = list != null && comparator != null ? list.size() : 0;

        // @since 3.0.0
        if (size < kSize) {
            final String message = "generator.permutation.out.of.bounds";
            final Exception cause = new Exception("kSize: " + kSize);
            throw new IllegalArgumentException(message, cause);
        }

        if (size == 0) {
            return emptyPermutation();
        }

        for (T item : list) {
            if (item == null) {
                throw new NullPointerException("permutation.list.item.null");
            }
        }

        final List<T> sortedList = new ArrayList<>(size);
        boolean basic = true;
        sortedList.addAll(list);
        sortedList.sort(comparator);
        for (int i = 1; i < size; i++) {
            final T left = sortedList.get(i - 1);
            final T right = sortedList.get(i);
            if (left == right || comparator.compare(left, right) == 0) {
                basic = false;
                break;
            }
        }

        if (!basic) {
            return new PermutationNTuple<>(orderedArray(size), unmodifiableList(sortedList), kSize);
        }

        return new PermutationBasic<>(orderedArray(size), unmodifiableList(sortedList), kSize);
    }

    /**
     * Creates an immutable linked permutation.
     *
     * @param <T>  the type
     * @param list the value elements
     * @return immutable basic permutation if no duplicates are detected, an N-Tuple otherwise
     * @throws NullPointerException if any of the list items are null
     * @since 2.0.0
     */
    public static <T> Permutation<T> newPermutation(List<T> list) {
        return newPermutation(list, list != null ? list.size() : 0);
    }

    /**
     * Creates an immutable linked permutation.
     *
     * @param <T>   the type
     * @param list  the value elements
     * @param kSize kSize value
     * @return immutable basic permutation if no duplicates are detected, an N-Tuple otherwise
     * @throws NullPointerException if any of the list items are null
     */
    public static <T> Permutation<T> newPermutation(List<T> list, int kSize) {
        if (list == null || list.size() == 0 || kSize < 1 || kSize > list.size()) {
            return emptyPermutation();
        }

        final int size = list.size();
        final List<T> groupedList = new ArrayList<>(size);
        boolean basic = true;

        for (T item : list) {
            if (item == null) {
                throw new NullPointerException("permutation.list.item.null");
            }
            int insert = getGroupInsertIndex(groupedList, item);
            if (insert != groupedList.size()) {
                basic = false;
                groupedList.add(insert, item);
            }
            else {
                if (basic && groupedList.size() > 0) {
                    if (groupedList.get(groupedList.size() - 1).equals(item)) {
                        basic = false;
                    }
                }

                groupedList.add(item);
            }
        }

        if (!basic) {
            return new PermutationNTuple<>(orderedArray(size), unmodifiableList(groupedList), kSize);
        }

        return new PermutationBasic<>(orderedArray(size), unmodifiableList(groupedList), kSize);
    }

    /**
     * Creates an immutable linked permutation.
     *
     * @param <T>             the type
     * @param list            the value elements
     * @param withRepetitions flag to specify if duplicates should be ignored
     * @return immutable linked permutation
     * @throws NullPointerException if any of the list items are null
     * @since 2.0.0
     */
    public static <T> Permutation<T> newPermutation(List<T> list, boolean withRepetitions) {
        return newPermutation(list, withRepetitions, list != null ? list.size() : 0);
    }

    /**
     * Creates an immutable linked permutation.
     *
     * @param <T>             the type
     * @param list            the value elements
     * @param withRepetitions flag to specify if duplicates should be ignored
     * @param kSize           kSize value
     * @return immutable linked permutation
     * @throws NullPointerException if any of the list items are null
     * @since 2.0.0
     */
    public static <T> Permutation<T> newPermutation(List<T> list, boolean withRepetitions, int kSize) {
        if (withRepetitions) {
            return newPermutation(list, kSize);
        }

        final int size = list.size();

        for (T item : list) {
            if (item == null) {
                throw new NullPointerException("permutation.list.item.null");
            }
        }

        return new PermutationBasic<>(orderedArray(size), unmodifiableList(list), kSize);
    }

    /**
     * Returns the index for group insertion.
     *
     * @param list list of elements
     * @param item item to insert
     * @param <T>  item type
     * @return index for group insertion
     * @since 2.0.0
     */
    private static <T> int getGroupInsertIndex(final List<T> list, T item) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }

        int index = size - 2;
        while (index >= 0) {
            if (list.get(index).equals(item)) {
                return index + 1;
            }
            index--;
        }

        return size;
    }

}
