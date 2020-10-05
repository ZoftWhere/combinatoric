package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static java.util.Comparator.naturalOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationCountTest {

    @Test
    void testBasicCount() {
        final var permutation = Generator.newPermutation(10);
        assertEquals(3628800, permutation.count().longValue());
    }

    @Test
    void testKCount() {
        for (int n = 1; n < 5; n++) {
            for (int k = 1; k <= n; k++) {
                var permutation = Generator.newPermutation(n, k);
                var count = permutation.count().longValue();
                var check = checkPermutations(n, k);
                assertEquals(check, count);
            }
        }
    }

    @Test
    void testMultiSetCount() {
        final var list = new ArrayList<>(List.of(1, 2, 2, 5, 5, 5, 5, 5));
        list.sort(naturalOrder());
        final var permutation = Generator.newPermutation(list, naturalOrder(), list.size());
        final var count = permutation.count();
        final var check = checkPermutations(permutation);
        assertEquals(check, count.longValue());
    }

    private long checkPermutations(int size, int kSize) {
        if (size == kSize) {
            var permutation = Generator.newPermutation(size);
            return checkPermutations(permutation);
        }

        var permutation = Generator.newPermutation(size, kSize);
        return checkPermutations(permutation);
    }

    private <T> long checkPermutations(Permutation<T> base) {
        long count = 0;
        var permutation = base;
        while (permutation.isPresent()) {
            permutation = permutation.next();
            count++;
        }
        return count;
    }

}
