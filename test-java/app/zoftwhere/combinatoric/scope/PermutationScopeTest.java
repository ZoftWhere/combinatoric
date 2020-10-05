package app.zoftwhere.combinatoric.scope;

import java.util.List;

import app.zoftwhere.combinatoric.Generator;
import org.junit.jupiter.api.Test;

/**
 * Test scope rules.
 */
class PermutationScopeTest {

    @Test
    void testVoidPermutation() {
        final var permutation = Generator.newPermutation(1);
        permutation.isPresent();
        permutation.isEmpty();
        permutation.size();
        permutation.index(0);
        permutation.index();
        permutation.progress(0);
        permutation.count();
    }

    @Test
    void testTypedPermutation() {
        final var permutation = Generator.newPermutation(List.of(1));
        permutation.isPresent();
        permutation.isEmpty();
        permutation.size();
        permutation.index(0);
        permutation.value(0);
        permutation.index();
        permutation.value();
        permutation.progress(0);
        permutation.count();
    }

}
