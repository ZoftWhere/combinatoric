package app.zoftwhere.combinatoric.scope;

import java.util.Base64;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Calculator.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FactorialScopeTest {

    @Test
    void testFactorial() {
        final var factorial = factorial(72);
        final var byteArray = factorial.toByteArray();
        final var baseString = Base64.getEncoder().encodeToString(byteArray);
        //noinspection SpellCheckingInspection
        assertEquals("AbVwV5ZpW2R383V6PWB6oa5zVaqcv/dbhh8g+EqZItcgxRhAAAAAAAAAAAA=", baseString);
    }

    @Test
    void TestFactorialNegative() {
        try {
            factorial(-1);
        }
        catch (RuntimeException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals("combinatoric.factorial.value.negative", e.getMessage());
            assertNotNull(e.getCause());
            assertEquals(Exception.class, e.getCause().getClass());
            assertEquals("value: -1", e.getCause().getMessage());
        }
    }

}