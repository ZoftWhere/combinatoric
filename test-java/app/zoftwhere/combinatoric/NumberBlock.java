package app.zoftwhere.combinatoric;

import java.util.ArrayList;
import java.util.List;

public class NumberBlock {

    private final int[] rowTotal;

    private final int[] columnTotal;

    private final int rowCount;

    private final int columnCount;

    private final List<Integer> pocket;

    public NumberBlock(int[] rowTotal, int[] columnTotal, int[] pileArray) {
        this.rowTotal = rowTotal;
        this.columnTotal = columnTotal;
        this.rowCount = rowTotal.length;
        this.columnCount = columnTotal.length;
        this.pocket = getPocket(pileArray, rowCount * columnCount);
    }

    public NumberBlock(int[] rowTotal, int[] columnTotal, List<Integer> pocket) {
        this.rowTotal = rowTotal;
        this.columnTotal = columnTotal;
        this.rowCount = rowTotal.length;
        this.columnCount = columnTotal.length;
        this.pocket = pocket;
    }

    public List<Permutation<Integer>> getSolutionList() {
        return this.getSolutionList(false);
    }

    public List<Permutation<Integer>> getSolutionList(boolean exitOnFirst) {
        final var boardTileCount = rowCount * columnCount;
        final List<Permutation<Integer>> solutionList = new ArrayList<>();

        // The pocket must contain at least enough tiles to tile the board.
        if (pocket.size() < boardTileCount) {
            return solutionList;
        }

        var permutation = Generator.newPermutation(pocket);

        while (permutation.isPresent()) {
            var move = boardTileCount - 1;
            var solution = true;

            for (var row = 0; (row < rowCount) && solution; row++) {
                if (sumRow(permutation, row) != rowTotal[row]) {
                    solution = false;
                    move = (row + 1) * columnCount - 1;
                }
            }

            for (var column = 0; (column < columnCount) && solution; column++) {
                if (sumColumn(permutation, column) != columnTotal[column]) {
                    solution = false;
                    move = (rowCount - 1) * columnCount + column;
                }
            }

            if (solution) {
                solutionList.add(permutation);
                if (exitOnFirst) {
                    return solutionList;
                }
            }

            permutation = permutation.next(move);
        }

        return solutionList;
    }

    int sumRow(Permutation<Integer> permutation, int rowNumber) {
        final var left = rowNumber * columnCount;
        final var right = left + columnCount - 1;

        var sum = 0;
        for (var i = left; i <= right; i++) {
            sum += permutation.value(i);
        }
        return sum;
    }

    int sumColumn(Permutation<Integer> permutation, int columnNumber) {
        var sum = 0;
        for (var row = 0; row < rowCount; row++) {
            final var index = row * columnCount + columnNumber;
            sum += permutation.value(index);
        }
        return sum;
    }

    public List<Integer> getPocket(int[] pileArray, int boardTileCount) {
        final var boardMax = getBoardMax();
        final var size = getPocketSize(pileArray, boardTileCount, boardMax);
        List<Integer> pocket = new ArrayList<>(size);

        for (var value = 0; value < pileArray.length; value++) {
            if (value > boardMax) {
                break;
            }

            final var count = pileArray[value];

            if (count < 0) {
                for (var q = 1; q <= boardTileCount; q++) {
                    pocket.add(value);
                }
                continue;
            }

            for (var q = 1; q <= count; q++) {
                pocket.add(value);
            }
        }

        return pocket;
    }

    int getBoardMax() {
        return Math.min(getMax(this.rowTotal), getMax(this.columnTotal));
    }

    int getMax(int[] array) {
        var max = array[0];
        for (var i = 1; i < array.length; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    int getPocketSize(int[] pileArray, int boardTileCount, int boardMax) {
        final var pileSize = pileArray.length;

        var size = 0;
        for (var value = 0; value < pileSize; value++) {
            if (value > boardMax) {
                break;
            }

            final var count = pileArray[value];
            if (count < 0) {
                size += boardTileCount;
                continue;
            }

            if (count > 0) {
                size += count;
            }
        }
        return size;
    }

}
