package app.zoftwhere.combinatoric.scope;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Calculator.nPk;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
