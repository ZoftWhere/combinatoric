package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Generator.emptyTuple;
import static app.zoftwhere.combinatoric.Generator.newTuple;
import static app.zoftwhere.combinatoric.TestHelper.assertClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

class KTupleTest {

    @Test
    void testEmpty() {
        assertClass(KTupleEmpty.class, emptyTuple());
        assertClass(KTupleEmpty.class, newTuple(0, 1));
        assertClass(KTupleEmpty.class, newTuple(1, 0));
        assertClass(KTupleEmpty.class, newTuple(0, List.of(1, 2, 3)));
    }

    @Test
    void testEmptyNewInstance() {
        // For code coverage.
        var tuple = new KTupleEmpty<>();
        var index = new int[0];
        var kSize = 0;
        var list = new ArrayList<>();
        tuple.newInstance(index, list, kSize);
        assertNotNull(tuple);
    }

    @Test
    void testEmptyNext() {
        emptyTuple().next();
        for (int i = -2; i <= 2; i++) {
            emptyTuple().next(i);
        }
    }

    @Test
    void testEmptyGetValue() {
        try {
            emptyTuple().value();
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(NoSuchElementException.class, e);
            assertEquals("tuple.empty.no.index", e.getMessage());
            assertNull(e.getCause());
        }

        try {
            emptyTuple().value(0);
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(NoSuchElementException.class, e);
            assertEquals("tuple.empty.no.index", e.getMessage());
            assertNull(e.getCause());
        }
    }

    @Test
    void testVoid() {
        var tuple = newTuple(1, 1);
        assertNotNull(tuple);
        assertClass(KTupleVoid.class, tuple);
        var index = tuple.index();
        assertEquals(1, index.length);
    }

    @Test
    void testVoidGetValue() {
        try {
            newTuple(1, 1).value();
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(NoSuchElementException.class, e);
            assertEquals("tuple.empty.no.index", e.getMessage());
            assertNull(e.getCause());
        }

        try {
            newTuple(1, 1).value(0);
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(NoSuchElementException.class, e);
            assertEquals("tuple.empty.no.index", e.getMessage());
            assertNull(e.getCause());
        }
    }

    @Test
    void testLinked() {
        var list = List.of(10, 20);
        var tuple = newTuple(1, list);
        assertNotNull(tuple);
        assertClass(KTupleLinked.class, tuple);
        var value = tuple.value();
        assertNotSame(list, value);
        assertEquals(list.size(), value.size());
        assertEquals(list.get(0), value.get(0));

        tuple = tuple.next().next();
        assertClass(KTupleEmpty.class, tuple);
    }

    @Test
    void testNext() {
        var tuple = (KTuple<Void>) new KTupleVoid(new int[2], 3);
        assertEquals("[0, 0]", tuple.toString());
        tuple = tuple.next();
        assertEquals("[0, 1]", tuple.toString());
        tuple = tuple.next();
        assertEquals("[0, 2]", tuple.toString());
        tuple = tuple.next(1);
        assertEquals("[1, 0]", tuple.toString());
        tuple = tuple.next(1);
        assertEquals("[1, 1]", tuple.toString());
        tuple = tuple.next(0);
        assertEquals("[2, 0]", tuple.toString());
        tuple = tuple.next(0);
        assertEquals("[]", tuple.toString());
    }

    @Test
    void testVoidNegativeSize() {
        try {
            newTuple(-1, 0);
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(IllegalArgumentException.class, e);
            assertEquals("generator.tuple.size.negative", e.getMessage());
            assertNotNull(e.getCause());
            assertClass(Exception.class, e.getCause());
            assertEquals("size: -1", e.getCause().getMessage());
        }

        try {
            newTuple(-1, null);
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(IllegalArgumentException.class, e);
            assertEquals("generator.tuple.size.negative", e.getMessage());
            assertNotNull(e.getCause());
            assertClass(Exception.class, e.getCause());
            assertEquals("size: -1", e.getCause().getMessage());
        }
    }

    @Test
    void testNullKSet() {
        try {
            newTuple(1, null);
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(IllegalArgumentException.class, e);
            assertEquals("generator.tuple.set.null", e.getMessage());
            assertNotNull(e.getCause());
            assertClass(Exception.class, e.getCause());
            assertEquals("size: 1 kSet: null", e.getCause().getMessage());
        }
    }

    @Test
    void testInvalidNext() {
        try {
            newTuple(1, 1).next(-1);
            fail("tuple.test.expected.exception");
        }
        catch (RuntimeException e) {
            assertClass(IllegalArgumentException.class, e);
            assertEquals("tuple.check.position.invalid.position", e.getMessage());
            assertNotNull(e.getCause());
            assertClass(Exception.class, e.getCause());
            assertEquals("size: 1 position: -1", e.getCause().getMessage());
        }
    }

}
