package example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import app.zoftwhere.combinatoric.NumberBlock;

import static app.zoftwhere.combinatoric.Generator.primitiveSequence;

public class RunMagic2Square {

    public static void main(String[] args) {
        for (var n = 3; n <= 3; n++) {
            final var boardTiles = n * n;
            long from = 0;
            long sum = primitiveSequence().base(from).exponent(1).increment(1).length(boardTiles).sum();
            if (sum % n != 0) {
                continue;
            }
            final var total = (int) (sum / n);
            final var sideTotal = makeTotal(total, n);
            final List<Integer> pocket = new ArrayList<>(n * n);

            for (var i = 0; i < boardTiles; i++) {
                final var value = BigInteger.valueOf(from + i).pow(1).intValue();
                pocket.add(value);
            }

            System.out.printf("Try %dx%d%n", n, n);

            final var list = new NumberBlock(sideTotal, sideTotal, pocket).getSolutionList(false);
            System.out.printf("%d: %d%n", n, list.size());
        }
    }

    private static int[] makeTotal(int value, int count) {
        final var array = new int[count];
        for (var i = 0; i < count; i++) {
            array[i] = value;
        }
        return array;
    }

}
