package app.zoftwhere.combinatoric.scope;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Calculator.nCr;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BinomialCoefficientScopeTest {

    @Test
    void testPascal() {
        assertEquals(1, nCr(0, 0).intValue());

        assertEquals(1, nCr(1, 0).intValue());
        assertEquals(1, nCr(1, 1).intValue());

        assertEquals(1, nCr(2, 0).intValue());
        assertEquals(2, nCr(2, 1).intValue());
        assertEquals(1, nCr(2, 2).intValue());

        assertEquals(1, nCr(3, 0).intValue());
        assertEquals(3, nCr(3, 1).intValue());
        assertEquals(3, nCr(3, 2).intValue());
        assertEquals(1, nCr(3, 3).intValue());
    }

    @Test
    void testNegativeNumber() {
        try {
            nCr(-1, 0);
        }
        catch (RuntimeException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals("calculator.ncr.number.negative", e.getMessage());
            assertNotNull(e.getCause());
            assertEquals(Exception.class, e.getCause().getClass());
            assertEquals("n: -1", e.getCause().getMessage());
        }
    }

    @Test
    void testOutOfBoundNumber() {
        try {
            nCr(0, -1);
        }
        catch (RuntimeException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals("calculator.ncr.number.out.of.bound", e.getMessage());
            assertNotNull(e.getCause());
            assertEquals(Exception.class, e.getCause().getClass());
            assertEquals("r: -1", e.getCause().getMessage());
        }

        try {
            nCr(0, 1);
        }
        catch (RuntimeException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals("calculator.ncr.number.out.of.bound", e.getMessage());
            assertNotNull(e.getCause());
            assertEquals(Exception.class, e.getCause().getClass());
            assertEquals("r: 1", e.getCause().getMessage());
        }
    }

}
