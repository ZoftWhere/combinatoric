package example;

import app.zoftwhere.combinatoric.Generator;

/**
 * <p>Run Index Permutation.
 * </p>
 * <p>This example shows how to run an indexed k-size permutation with progress.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
class RunIndexPermutation {

    public static void main(String[] args) {
        final var size = 6;
        final var kSize = 4;
        var permutation = Generator.newPermutation(size, kSize);

        System.out.println(permutation);
        var position = kSize - 1;

        while (position >= 0) {
            final var test = permutation.progress(position);

            if (test.isEmpty()) {
                position--;
                continue;
            }

            if (test.isPresent()) {
                permutation = test;
                System.out.println(permutation);
                position = kSize - 1;
            }
        }
    }

}
