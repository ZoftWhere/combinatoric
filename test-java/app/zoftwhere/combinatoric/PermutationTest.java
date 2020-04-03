package app.zoftwhere.combinatoric;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static app.zoftwhere.combinatoric.Generator.newPermutation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class PermutationTest {

    @Test
    void testEmpty() {
        Permutation<Void> permutation = newPermutation(0);
        assertEquals(Integer.valueOf(0), permutation.size());
        assertTrue(permutation.isEmpty());
        assertFalse(permutation.isPresent());

        try {
            permutation.index(0);
            fail("expected.no.such.element.exception");
        }
        catch (NoSuchElementException ignore) {}

        try {
            permutation.index();
            fail("expected.no.such.element.exception");
        }
        catch (NoSuchElementException ignore) {}

        try {
            permutation.value(0);
            fail("expected.no.such.element.exception");
        }
        catch (NoSuchElementException ignore) {}

        try {
            permutation.value();
            fail("expected.no.such.element.exception");
        }
        catch (NoSuchElementException ignore) {}

        Permutation<Void> progress = permutation.progress(1);
        assertNotNull(progress);
        assertTrue(progress.isEmpty());
        assertFalse(progress.isPresent());

        assertNotNull(permutation.next());
        assertNotNull(permutation.next(0));

        assertClass(newPermutation(0), PermutationEmpty.class);
        assertClass(newPermutation(1, 0), PermutationEmpty.class);
        assertClass(newPermutation(1).next(), PermutationEmpty.class);
        assertClass(newPermutation(1).next(0), PermutationEmpty.class);
        assertClass(newPermutation(1).progress(0), PermutationEmpty.class);
        assertClass(newPermutation(2, 1).progress(1), PermutationEmpty.class);
        assertClass(newPermutation(null, null, 0), PermutationEmpty.class);
        assertClass(newPermutation(List.of(0)).next(), PermutationEmpty.class);
        assertClass(newPermutation(List.of(0)).next(0), PermutationEmpty.class);
        assertClass(newPermutation((List<Integer>) null), PermutationEmpty.class);
        assertClass(newPermutation(new ArrayList<Integer>(0)), PermutationEmpty.class);

        assertClass(newPermutation(List.of(0), false).progress(0), PermutationEmpty.class);
        assertClass(newPermutation(Arrays.asList(1, 2, 1), 1).progress(2), PermutationEmpty.class);
    }

    @Test
    void testBasicPermutationCreator() {
        Permutation<Integer> permutation;

        permutation = newPermutation(List.of(1, 2, 3, 4));
        assertClass(permutation, PermutationBasic.class);

        permutation = newPermutation(List.of(1, 2, 3, 4), Comparator.naturalOrder());
        assertClass(permutation, PermutationBasic.class);

        permutation = newPermutation(List.of(1, 2, 3, 4), true);
        assertClass(permutation, PermutationBasic.class);

        permutation = newPermutation(List.of(1, 2, 3, 4), false);
        assertClass(permutation, PermutationBasic.class);

        permutation = newPermutation(List.of(1, 2, 3, 4), Comparator.naturalOrder(), 3);
        assertClass(permutation, PermutationBasic.class);

        permutation = newPermutation(List.of(1, 2, 3, 4), true, 3);
        assertClass(permutation, PermutationBasic.class);

        permutation = newPermutation(List.of(1, 2, 3, 4), false, 3);
        assertClass(permutation, PermutationBasic.class);
    }

    @Test
    void testPermutationTupleCreator() {
        Permutation<Integer> permutation;

        permutation = newPermutation(List.of(1, 1, 1, 1), Comparator.naturalOrder());
        assertClass(permutation, PermutationNTuple.class);

        permutation = newPermutation(List.of(1, 1, 2, 2), Comparator.naturalOrder());
        assertClass(permutation, PermutationNTuple.class);

        permutation = newPermutation(List.of(1, 1, 1, 1));
        assertClass(permutation, PermutationNTuple.class);

        permutation = newPermutation(List.of(1, 1, 2, 2));
        assertClass(permutation, PermutationNTuple.class);

        permutation = newPermutation(List.of(1, 1, 1, 1), true);
        assertClass(permutation, PermutationNTuple.class);

        permutation = newPermutation(List.of(1, 1, 2, 2), true);
        assertClass(permutation, PermutationNTuple.class);
    }

    @Test
    void testIndexArrayBounds() {
        try {
            newPermutation(1).index(-1);
            fail("expected.array.index.out.of.bounds.exception");
        }
        catch (ArrayIndexOutOfBoundsException ignore) {}

        try {
            newPermutation(1).index(1);
            fail("expected.array.index.out.of.bounds.exception");
        }
        catch (ArrayIndexOutOfBoundsException ignore) {}

        try {
            newPermutation(1).progress(-1);
            fail("expected.array.index.out.of.bounds.exception");
        }
        catch (ArrayIndexOutOfBoundsException ignore) {}

        try {
            newPermutation(1).progress(1);
            fail("expected.array.index.out.of.bounds.exception");
        }
        catch (ArrayIndexOutOfBoundsException ignore) {}

        try {
            newPermutation(1, 4);
            fail("expected.array.index.out.of.bounds.exception");
        }
        catch (ArrayIndexOutOfBoundsException ignore) {}

        try {
            newPermutation(List.of(1, 2, 3), Comparator.naturalOrder(), 4);
            fail("expected.array.index.out.of.bounds.exception");
        }
        catch (ArrayIndexOutOfBoundsException ignore) {}
    }

    @Test
    void testBasicGetValue() {
        Permutation<Void> permutation = newPermutation(1);
        try {
            permutation.value(0);
            fail("expected.no.such.element.exception");
        }
        catch (NoSuchElementException ignore) {}

        try {
            permutation.value();
            fail("expected.no.such.element.exception");
        }
        catch (NoSuchElementException ignore) {}
    }

    @Test
    void testTypedWithNullItem() {
        try {
            newPermutation(Arrays.asList(1, null, 3, 4));
            fail("expected.null.pointer.exception");
        }
        catch (NullPointerException ignore) {}

        try {
            newPermutation(Arrays.asList(1, null, 3, 4), false);
            fail("expected.null.pointer.exception");
        }
        catch (NullPointerException ignore) {}

        try {
            newPermutation(Arrays.asList(1, null, 3, 4), true);
            fail("expected.null.pointer.exception");
        }
        catch (NullPointerException ignore) {}

        try {
            newPermutation(Arrays.asList(1, null, 3, 4), Comparator.naturalOrder());
            fail("expected.null.pointer.exception");
        }
        catch (NullPointerException ignore) {}
    }

    @Test
    void testKSize() {
        Permutation<Integer> permutation;

        permutation = newPermutation(List.of(1, 2, 3, 4), 3);
        assertEquals(3, permutation.kSize());

        permutation = newPermutation(List.of(1, 1, 2, 2), false, 3);
        assertEquals(3, permutation.kSize());

        permutation = newPermutation(List.of(1, 1, 2, 2), true, 3);
        assertEquals(3, permutation.kSize());

        permutation = newPermutation(List.of(1, 2, 3, 4), true, 3);
        assertEquals(3, permutation.kSize());

        permutation = newPermutation(List.of(1, 1, 2, 2), Comparator.naturalOrder(), 3);
        assertEquals(3, permutation.kSize());

        permutation = newPermutation(List.of(1, 2, 3, 4), Comparator.naturalOrder(), 3);
        assertEquals(3, permutation.kSize());
    }

    @Test
    void testVoidNext() {
        final String[] expected = {
            "[0, 1, 2]", //
            "[0, 2, 1]", //
            "[1, 0, 2]", //
            "[1, 2, 0]", //
            "[2, 0, 1]", //
            "[2, 1, 0]", //
            "[]"
        };
        final int size = 3;

        Permutation<Void> permutation = newPermutation(size);
        int index = 0;
        assertNotNull(permutation);
        assertTrue(permutation.isPresent());
        assertFalse(permutation.isEmpty());
        assertEquals(size, permutation.size());

        do {
            assertEquals(expected[index], permutation.toString());
            permutation = permutation.next();
            index++;
        }
        while (permutation.isPresent());
        assertTrue(permutation.isEmpty());
        assertFalse(permutation.isPresent());
        assertEquals(expected[index], permutation.toString());

        if (!(permutation instanceof PermutationEmpty)) {
            fail("permutation.type.not.empty");
        }
    }

    @Test
    void testBasicNext() {
        final String[] expected = {
            "[0:0, 1:1, 2:2]", //
            "[0:0, 2:2, 1:1]", //
            "[1:1, 0:0, 2:2]", //
            "[1:1, 2:2, 0:0]", //
            "[2:2, 0:0, 1:1]", //
            "[2:2, 1:1, 0:0]", //
            "[]"
        };
        final int size = 3;

        Permutation<Integer> permutation = newPermutation(List.of(0, 1, 2), false);
        int index = 0;
        assertNotNull(permutation);
        assertTrue(permutation.isPresent());
        assertFalse(permutation.isEmpty());
        assertEquals(size, permutation.size());

        do {
            assertEquals(expected[index], permutation.toString());
            permutation = permutation.next();
            index++;
        }
        while (permutation.isPresent());
        assertTrue(permutation.isEmpty());
        assertFalse(permutation.isPresent());
        assertEquals(expected[index], permutation.toString());

        if (!(permutation instanceof PermutationEmpty)) {
            fail("permutation.type.not.empty");
        }
    }

    @Test
    void testVoidKNext() {
        final String[] expected = {
            "[0][1, 2]",
            "[1][0, 2]",
            "[2][0, 1]",
            "[]"
        };
        final int size = 3;
        final int kSize = 1;

        Permutation<Void> permutation = newPermutation(size, kSize);
        int index = 0;
        assertNotNull(permutation);
        assertTrue(permutation.isPresent());
        assertFalse(permutation.isEmpty());
        assertEquals(size, permutation.size());

        do {
            assertEquals(expected[index], permutation.toString());
            permutation = permutation.next();
            index++;
        }
        while (permutation.isPresent());
        assertTrue(permutation.isEmpty());
        assertFalse(permutation.isPresent());
        assertEquals(expected[index], permutation.toString());

        if (!(permutation instanceof PermutationEmpty)) {
            fail("permutation.type.not.empty");
        }
    }

    @Test
    void testKTuple() {
        final List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3);
        final String[] expected = {
            "[0:1, 1:1][2:2, 3:2, 4:3, 5:3]", //
            "[0:1, 2:2][1:1, 3:2, 4:3, 5:3]", //
            "[0:1, 4:3][1:1, 2:2, 3:2, 5:3]", //
            "[2:2, 0:1][1:1, 3:2, 4:3, 5:3]", //
            "[2:2, 3:2][0:1, 1:1, 4:3, 5:3]", //
            "[2:2, 4:3][0:1, 1:1, 3:2, 5:3]", //
            "[4:3, 0:1][1:1, 2:2, 3:2, 5:3]", //
            "[4:3, 2:2][0:1, 1:1, 3:2, 5:3]", //
            "[4:3, 5:3][0:1, 1:1, 2:2, 3:2]", //
            "[]"
        };
        final int size = list.size();

        Permutation<Integer> permutation = newPermutation(list, Comparator.naturalOrder(), 2);
        int index = 0;
        assertNotNull(permutation);
        assertTrue(permutation.isPresent());
        assertFalse(permutation.isEmpty());
        assertEquals(size, permutation.size());

        do {
            assertEquals(expected[index], permutation.toString());
            permutation = permutation.next(size - 1);
            index++;
        }
        while (permutation.isPresent());

        assertTrue(permutation.isEmpty());
        assertFalse(permutation.isPresent());
        assertEquals(expected[index], permutation.toString());

        if (!(permutation instanceof PermutationEmpty)) {
            fail("permutation.type.not.empty");
        }
    }

    @Test
    void testTypedNext() {
        final List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3);
        final String[] expected = {
            "[0:1, 1:1, 2:2, 3:2, 4:3, 5:3]",
            "[0:1, 2:2, 1:1, 3:2, 4:3, 5:3]",
            "[0:1, 4:3, 1:1, 2:2, 3:2, 5:3]",
            "[2:2, 0:1, 1:1, 3:2, 4:3, 5:3]",
            "[2:2, 3:2, 0:1, 1:1, 4:3, 5:3]",
            "[2:2, 4:3, 0:1, 1:1, 3:2, 5:3]",
            "[4:3, 0:1, 1:1, 2:2, 3:2, 5:3]",
            "[4:3, 2:2, 0:1, 1:1, 3:2, 5:3]",
            "[4:3, 5:3, 0:1, 1:1, 2:2, 3:2]",
            "[]"
        };
        final int size = list.size();

        Permutation<Integer> permutation = newPermutation(list, Comparator.naturalOrder());
        int index = 0;
        assertNotNull(permutation);
        assertTrue(permutation.isPresent());
        assertFalse(permutation.isEmpty());
        assertEquals(size, permutation.size());

        do {
            assertEquals(expected[index], permutation.toString());
            permutation = permutation.next(1);
            index++;
        }
        while (permutation.isPresent());

        assertTrue(permutation.isEmpty());
        assertFalse(permutation.isPresent());
        assertEquals(expected[index], permutation.toString());

        if (!(permutation instanceof PermutationEmpty)) {
            fail("permutation.type.not.empty");
        }
    }

    private static void assertClass(Object object, Class<?> objectClass) {
        String expected = objectClass.getName();
        String actual = object.getClass().getName();
        if (Objects.equals(expected, actual)) {
            return;
        }

        throw new AssertionFailedError("Object not of the expected type.", expected, actual);
    }

}