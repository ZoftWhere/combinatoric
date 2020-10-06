package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;

import static app.zoftwhere.combinatoric.Generator.emptyPermutation;

class BlockOptimisation extends NumberBlock {

    private final int[] rowTotal;

    private final int[] columnTotal;

    private final int[] pileArray;

    private final int rowCount;

    private final int columnCount;

    BlockOptimisation(int[] rowTotal, int[] columnTotal, int[] pileArray) {
        super(rowTotal, columnTotal, pileArray);
        this.rowTotal = rowTotal;
        this.columnTotal = columnTotal;
        this.pileArray = pileArray;
        this.rowCount = rowTotal.length;
        this.columnCount = columnTotal.length;
    }

    SolutionPair testBlockSolutions() {
        long iterationCount = 0;
        final var boardTileCount = rowCount * columnCount;

        final var pocket = getPocket(pileArray, boardTileCount);
        final var solutionList = new ArrayList<Permutation<Integer>>();
        var permutation = Generator.newPermutation(pocket);

        while (permutation.isPresent()) {
            var move = boardTileCount - 1;
            var solution = true;

            for (var row = 0; (row < rowCount) && solution; row++) {

                final var rowOffset = row * columnCount;
                for (var column = 0; column < columnCount; column++) {
                    final int value = permutation.value(rowOffset + column);
                    if (value <= columnTotal[column]) {
                        continue;
                    }

                    if (value <= rowTotal[row]) {
                        continue;
                    }

                    solution = false;
                    move = rowOffset + column - 1;

                    if (move == -1) {
                        permutation = emptyPermutation();
                    }

                    break;
                }

                if (permutation.isEmpty()) {
                    break;
                }

                final var rowSum = sumRow(permutation, row);
                if (rowSum != rowTotal[row]) {
                    solution = false;
                    move = (row + 1) * columnCount - 1;

                    break;
                }
            }

            if (permutation.isEmpty()) {
                break;
            }

            for (var column = 0; (column < columnCount) && solution; column++) {
                if (sumColumn(permutation, column) != columnTotal[column]) {
                    solution = false;
                    move = (rowCount - 1) * columnCount + column;
                }
            }

            if (solution) {
                solutionList.add(permutation);

                System.out.println(permutation.toString());
                System.out.println("Added to solution.");
                System.out.println();
            }

            iterationCount++;
            permutation = permutation.next(move);
        }

        return new SolutionPair(iterationCount, solutionList);
    }

    public static class SolutionPair {

        private final Long left;

        private final List<Permutation<Integer>> right;

        SolutionPair(Long left, List<Permutation<Integer>> right) {
            this.left = left;
            this.right = right;
        }

        Long getLeft() {
            return left;
        }

        List<Permutation<Integer>> getRight() {
            return right;
        }

    }

}
