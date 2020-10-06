package app.zoftwhere.combinatoric.scope;

import java.math.BigInteger;
import java.util.Base64;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Calculator.factorial;
import static app.zoftwhere.combinatoric.TestHelper.assertClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FactorialScopeTest {

    @Test
    void testBasic() {
        assertEquals(BigInteger.ONE, factorial(0));
        assertEquals(BigInteger.ONE, factorial(1));
        assertEquals(BigInteger.TWO, factorial(2));
        assertEquals(6, factorial(3).intValue());
        assertEquals(24, factorial(4).intValue());
    }

    @Test
    void testLarge() {
        final var factorial = factorial(72);
        final var byteArray = factorial.toByteArray();
        final var baseString = Base64.getEncoder().encodeToString(byteArray);
        //noinspection SpellCheckingInspection
        assertEquals("AbVwV5ZpW2R383V6PWB6oa5zVaqcv/dbhh8g+EqZItcgxRhAAAAAAAAAAAA=", baseString);
    }

    @Test
    void testFactorialNegative() {
        try {
            factorial(-1);
        }
        catch (RuntimeException e) {
            assertClass(IllegalArgumentException.class, e);
            assertEquals("calculator.factorial.value.negative", e.getMessage());
            assertNotNull(e.getCause());
            assertClass(Exception.class, e.getCause());
            assertEquals("value: -1", e.getCause().getMessage());
        }
    }

}
