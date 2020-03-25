package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;

import static app.zoftwhere.combinatoric.Generator.empty;

public class BlockOptimisation extends NumberBlock {

    private final int[] rowTotal;
    private final int[] columnTotal;
    private final int[] pileArray;
    private final int rowCount;
    private final int columnCount;

    public BlockOptimisation(int[] rowTotal, int[] columnTotal, int[] pileArray) {
        super(rowTotal, columnTotal, pileArray);
        this.rowTotal = rowTotal;
        this.columnTotal = columnTotal;
        this.pileArray = pileArray;
        this.rowCount = rowTotal.length;
        this.columnCount = columnTotal.length;
    }

    public SolutionPair testBlockSolutions() {
        long iterationCount = 0;
        final int boardTileCount = rowCount * columnCount;

        final List<Integer> pocket = getPocket(pileArray, boardTileCount);
        final List<Permutation<Integer>> solutionList = new ArrayList<>();
        Permutation<Integer> permutation = Generator.newPermutation(pocket);

        while (permutation.isPresent()) {
            int move = boardTileCount - 1;
            boolean solution = true;

            for (int row = 0; (row < rowCount) && solution; row++) {

                final int rowOffset = row * columnCount;
                for (int column = 0; column < columnCount; column++) {
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
                        permutation = empty();
                    }

//                    System.out.println(permutation.toString());≤
//                    System.out.printf("Move due to column total for cell row:%d column:%d (%d)%n", row, column, move);
//                    System.out.println();
                    break;
                }

                if (permutation.isEmpty()) {
                    break;
                }

                final int rowSum = sumRow(permutation, row);
                if (rowSum != rowTotal[row]) {
                    solution = false;
                    move = (row + 1) * columnCount - 1;

//                    System.out.println(permutation.toString());
//                    System.out.println("Move due to row total for row " + row + " (" + move + ")");
//                    System.out.println();
                    break;
                }
            }

            if (permutation.isEmpty()) {
                break;
            }

            for (int column = 0; (column < columnCount) && solution; column++) {
                if (sumColumn(permutation, column) != columnTotal[column]) {
                    solution = false;
                    move = (rowCount - 1) * columnCount + column;

//                    System.out.println(permutation.toString());
//                    System.out.println("Move due to column total for column " + column + " (" + move + ")");
//                    System.out.println();
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

        public Long getLeft() {
            return left;
        }

        public List<Permutation<Integer>> getRight() {
            return right;
        }

    }

}