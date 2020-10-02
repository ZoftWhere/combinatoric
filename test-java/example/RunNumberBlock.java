package example;

import app.zoftwhere.combinatoric.NumberBlock;

public class RunNumberBlock {

    public static void main(String[] args) {
        final int[] rowTotal = {2, 4, 6};
        final int[] columnTotal = {2, 4, 6};
        int[] pileArray = {-1, -1, 1, 2};

        final var solutionList = new NumberBlock(rowTotal, columnTotal, pileArray).getSolutionList();

        final var rowCount = rowTotal.length;
        final var columnCount = columnTotal.length;
        final var boardSize = rowCount * columnCount;
        for (final var permutation : solutionList) {
            System.out.printf("%d", permutation.value(0));
            for (var i = 1; i < boardSize; i++) {
                System.out.printf(" %d", permutation.value(i));
            }
            System.out.println();
        }
    }

}
