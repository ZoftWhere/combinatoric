package app.zoftwhere.combinatoric.scope;

import java.util.List;

import app.zoftwhere.combinatoric.Generator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TupleScopeTest {

    @Test
    void testGenerator() {
        assertNotNull(Generator.emptyTuple());
        assertNotNull(Generator.newTuple(0, 0));
        assertNotNull(Generator.newTuple(1, 1));
        assertNotNull(Generator.newTuple(1, List.of(10, 20, 30)));
    }

}
