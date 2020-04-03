package example;

import app.zoftwhere.combinatoric.Generator;
import app.zoftwhere.combinatoric.Permutation;

import java.util.Arrays;

public class RunIndexPermutation {

    public static void main(String[] args) {
        final int size = 4;
        Permutation<Void> permutation = Generator.newPermutation(size);

        System.out.println(Arrays.toString(permutation.index()));
        int position = size - 1;

        while (position >= 0) {
            final Permutation<Void> test = permutation.progress(position);

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
