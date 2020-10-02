package example;

import java.util.Arrays;

import app.zoftwhere.combinatoric.Generator;

public class RunIndexPermutation {

    public static void main(String[] args) {
        final var size = 4;
        var permutation = Generator.newPermutation(size);

        System.out.println(Arrays.toString(permutation.index()));
        var position = size - 1;

        while (position >= 0) {
            final var test = permutation.progress(position);

            if (test.isEmpty()) {
                position--;
                continue;
            }

            if (test.isPresent()) {
                permutation = test;
                System.out.println(Arrays.toString(permutation.index()));
                position = size - 1;
            }
        }
    }

}
