package app.zoftwhere.combinatoric.scope;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Calculator.nPk;
import static app.zoftwhere.combinatoric.TestHelper.assertClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PartialPermutationTest {

    @Test
    void testBasic() {
        assertEquals(1, nPk(0, 0).longValue());
        assertEquals(1, nPk(1, 0).longValue());
        assertEquals(1, nPk(1, 1).longValue());
        assertEquals(1, nPk(2, 0).longValue());
        assertEquals(2, nPk(2, 1).longValue());
        assertEquals(2, nPk(2, 2).longValue());
        assertEquals(3, nPk(3, 1).longValue());
        assertEquals(6, nPk(3, 2).longValue());
        assertEquals(6, nPk(3, 3).longValue());
    }

    @Test
    void testLarge() {
        var expected = 0x14b13e8b996df000L;
        var n = 50;
        var k = 11;
        var actual = nPk(n, k).longValueExact();
        assertEquals(expected, actual);
    }

    @Test
    void testNegative() {
        try {
            nPk(-1, 0);
        }
        catch (RuntimeException e) {
            assertClass(IllegalArgumentException.class, e);
            assertEquals("calculator.npk.number.negative", e.getMessage());
            assertNotNull(e.getCause());
            assertClass(Exception.class, e.getCause());
            assertEquals("n: -1", e.getCause().getMessage());
        }
    }

    @Test
    void testOutOfBound() {
        try {
            nPk(1, -1);
        }
        catch (RuntimeException e) {
            assertClass(IllegalArgumentException.class, e);
            assertEquals("calculator.npk.number.out.of.bound", e.getMessage());
            assertNotNull(e.getCause());
            assertClass(Exception.class, e.getCause());
            assertEquals("k: -1", e.getCause().getMessage());
        }
    }

}
