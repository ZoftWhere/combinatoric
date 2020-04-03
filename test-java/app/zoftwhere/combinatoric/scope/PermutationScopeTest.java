package app.zoftwhere.combinatoric.scope;

import app.zoftwhere.combinatoric.Generator;
import app.zoftwhere.combinatoric.Permutation;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Test scope rules.
 */
class PermutationScopeTest {

    @Test
    void testVoidPermutation() {
        Permutation<Void> permutation = Generator.newPermutation(1);
        permutation.isPresent();
        permutation.isEmpty();
        permutation.size();
        permutation.index(0);
        permutation.index();
        permutation.progress(0);
    }

    @Test
    void testTypedPermutation() {
        Permutation<Integer> permutation = Generator.newPermutation(List.of(1));
        permutation.isPresent();
        permutation.isEmpty();
        permutation.size();
        permutation.index(0);
        permutation.value(0);
        permutation.index();
        permutation.value();
        permutation.progress(0);
    }

}