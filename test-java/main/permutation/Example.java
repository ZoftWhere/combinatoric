package main.permutation;

import app.zoftwhere.combinatoric.Generator;
import app.zoftwhere.combinatoric.Permutation;

public class Example {

    public static void main(String[] args) {
        Permutation<Void> permutation;

        permutation = Generator.newPermutation(5);
        // [0, 1, 2, 3, 4]
        System.out.println(permutation);
        permutation = permutation.progress(1);
        // [0, 2, 1, 3, 4]
        System.out.println(permutation);
        permutation = permutation.progress(1);
        // [0, 3, 1, 2, 4]
        System.out.println(permutation);
    }

}
