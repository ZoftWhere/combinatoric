package app.zoftwhere.combinatoric;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PermutationEmptyTest {

    @Test
    void testNewInstance() {
        // For code coverage.
        var permutation = new PermutationEmpty<>();
        var index = new int[0];
        var kSize = 0;
        var list = new ArrayList<>();
        permutation.newInstance(index, list, kSize);
        assertNotNull(permutation);
    }

    @Test
    void testCount() {
        var permutation = new PermutationEmpty<>();
        var count = permutation.count();
        assertEquals(BigInteger.ZERO, count);
    }

}