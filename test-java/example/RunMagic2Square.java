package example;

import app.zoftwhere.combinatoric.NumberBlock;
import app.zoftwhere.combinatoric.Permutation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static app.zoftwhere.combinatoric.Generator.primitiveSequence;

public class RunMagic2Square {

    public static void main(String[] args) {
        for (int n = 3; n <= 3; n++) {
            final int boardTiles = n * n;
            long from = 0;
            long sum = primitiveSequence().base(from).exponent(1).increment(1).length(boardTiles).sum();
            if (sum % n != 0) {
                continue;
            }
            int total = (int) (sum / n);
            final int[] sideTotal = makeTotal(total, n);
            final List<Integer> pocket = new ArrayList<>(n * n);

            for (int i = 0; i < boardTiles; i++) {
                int value = BigInteger.valueOf(from + i).pow(1).intValue();
                pocket.add(value);
            }

            System.out.printf("Try %dx%d%n", n, n);

            List<Permutation<Integer>> list = new NumberBlock(sideTotal, sideTotal, pocket).getSolutionList(false);
            System.out.printf("%d: %d%n", n, list.size());
        }
    }

    private static int[] makeTotal(int value, int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = value;
        }
        return array;
    }

}
