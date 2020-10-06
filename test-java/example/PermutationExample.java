package example;

import app.zoftwhere.combinatoric.Generator;
import app.zoftwhere.combinatoric.Permutation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>Permutation Example class.
 * </p>
 * <p> The example shows the various ways to construct a permutation.
 * </p>
 *
 * @author Osmund
 * @noinspection JoinDeclarationAndAssignmentJava
 * @since 1.0.0
 */
class PermutationExample {

    @Test
    void testEmpty() {
        var expected = "[]";
        var permutation = Generator.emptyPermutation();
        assertEquals(expected, permutation.toString());
    }

    @Test
    void testBasic() {
        var expected = (String) null;
        var permutation = (Permutation<Void>) null;

        expected = "[0, 1, 2, 3, 4]";
        permutation = Generator.newPermutation(5);
        assertEquals(expected, permutation.toString());

        expected = "[0, 2, 1, 3, 4]";
        permutation = permutation.progress(1);
        assertEquals(expected, permutation.toString());

        expected = "[0, 3, 1, 2, 4]";
        permutation = permutation.progress(1);
        assertEquals(expected, permutation.toString());
    }

    @Test
    void testKSize() {
        var expected = (String) null;
        var permutation = (Permutation<Void>) null;

        expected = "[0, 1, 2, 3][4, 5, 6, 7, 8, 9]";
        permutation = Generator.newPermutation(10, 4);
        assertEquals(expected, permutation.toString());

        expected = "[0, 1, 2, 4][3, 5, 6, 7, 8, 9]";
        permutation = permutation.progress(3);
        assertEquals(expected, permutation.toString());
    }

}
