package example;

import java.math.BigInteger;
import java.util.List;

import app.zoftwhere.combinatoric.Generator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>K-Tuple Example.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
class KTupleExample {

    @Test
    void createAnEmptyTuple() {
        var tuple = Generator.<String>emptyTuple();
        assertNotNull(tuple);
        assertFalse(tuple.isPresent());
        assertTrue(tuple.isEmpty());
        assertEquals(0, tuple.size());
        assertEquals(0, tuple.kSize());
        assertEquals("[]", tuple.toString());
        assertEquals(BigInteger.ZERO, tuple.count());
    }

    @Test
    void createIndexOnlyTuple() {
        var tuple = Generator.newTuple(1, 10);
        assertNotNull(tuple);
        assertTrue(tuple.isPresent());
        assertFalse(tuple.isEmpty());
        assertEquals(1, tuple.size());
        assertEquals(10, tuple.kSize());
        assertEquals("[0]", tuple.toString());
        assertEquals(BigInteger.TEN, tuple.count());
    }

    @Test
    void createdWordLinkedTuple() {
        var list = List.of(10, 20, 30);
        var tuple = Generator.newTuple(5, list);
        assertNotNull(tuple);
        assertTrue(tuple.isPresent());
        assertFalse(tuple.isEmpty());
        assertEquals(5, tuple.size());
        assertEquals(3, tuple.kSize());
        assertEquals(0, tuple.index(0));
        assertEquals(10, tuple.value(0));
        assertEquals("[0:10, 0:10, 0:10, 0:10, 0:10]", tuple.toString());
        assertEquals(243, tuple.count().longValue());
    }

}
