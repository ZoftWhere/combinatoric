package example;

import java.util.Arrays;
import java.util.List;

import app.zoftwhere.combinatoric.Generator;

import static java.util.Comparator.naturalOrder;

class RunValuePermutation {

    public static void main(String[] args) {
        new RunValuePermutation().runValueList();
    }

    private void runValueList() {
        var permutation = Generator.newPermutation(List.of(77, 88, 99, 77, 88, 99), naturalOrder());
        final var list = permutation.value();
        final var size = list.size();

        System.out.printf("%s %s%n",
            Arrays.toString(permutation.index()),
            Arrays.toString(permutation.value().toArray()));

        var position = size - 1;

        while (position >= 0) {
            final var test = permutation.progress(position);

            if (test.isEmpty()) {
                position--;
                continue;
            }

            if (test.isPresent()) {
                permutation = test;
                final var index = Arrays.toString(permutation.index());
                final var value = Arrays.toString(permutation.value().toArray());
                System.out.printf("%s %s%n", index, value);
                position = size - 1;
            }
        }
    }

}
