package example;

import app.zoftwhere.combinatoric.Generator;
import app.zoftwhere.combinatoric.Permutation;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class RunValuePermutation {

    public static void main(String[] args) {
        new RunValuePermutation().runValueList();
    }

    private void runValueList() {
        Permutation<Integer> permutation = Generator.newPermutation(List.of(77, 88, 99, 77, 88, 99), naturalOrder());
        final List<Integer> list = permutation.value();
        final int size = list.size();

        System.out.printf("%s %s%n",
            Arrays.toString(permutation.index()),
            Arrays.toString(permutation.value().toArray()));

        int position = size - 1;

        while (position >= 0) {
            final Permutation<Integer> test = permutation.progress(position);

            if (test.isEmpty()) {
                position--;
                continue;
            }

            if (test.isPresent()) {
                permutation = test;
                String index = Arrays.toString(permutation.index());
                String value = Arrays.toString(permutation.value().toArray());
                System.out.printf("%s %s%n", index, value);
                position = size - 1;
            }
        }
    }

}
