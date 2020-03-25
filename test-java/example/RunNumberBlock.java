package example;

import app.zoftwhere.combinatoric.NumberBlock;
import app.zoftwhere.combinatoric.Permutation;

import java.util.List;

public class RunNumberBlock {

    public static void main(String[] args) {
        final int[] rowTotal = {2, 4, 6};
        final int[] columnTotal = {2, 4, 6};
        int[] pileArray = {-1, -1, 1, 2};

        List<Permutation<Integer>> solutionList = new NumberBlock(rowTotal, columnTotal, pileArray).getSolutionList();

        final int rowCount = rowTotal.length;
        final int columnCount = columnTotal.length;
        final int boardSize = rowCount * columnCount;
        for (Permutation<Integer> permutation : solutionList) {
            System.out.printf("%d", permutation.value(0));
            for (int i = 1; i < boardSize; i++) {
                System.out.printf(" %d", permutation.value(i));
            }
            System.out.println();
        }
    }

}
