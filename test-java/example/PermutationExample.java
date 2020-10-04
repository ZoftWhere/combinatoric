package example;

import app.zoftwhere.combinatoric.Generator;
import app.zoftwhere.combinatoric.Permutation;


/**
 * <p>Permutation Example class.
 * </p>
 * <p> The example shows the various ways to construct a permutation.
 * </p>
 *
 * @author Osmund
 * @since 1.0.0
 */
public class PermutationExample {

    public static void main(String[] args) {
        Permutation<Void> permutation;

        // [0, 1, 2, 3, 4]
        permutation = Generator.newPermutation(5);
        System.out.println(permutation);

        // [0, 2, 1, 3, 4]
        permutation = permutation.progress(1);
        System.out.println(permutation);

        // [0, 3, 1, 2, 4]
        permutation = permutation.progress(1);
        System.out.println(permutation);

        // []
        permutation = Generator.emptyPermutation();
        System.out.println(permutation);
    }

}
