package app.zoftwhere.combinatoric;

import java.util.List;

import org.junit.jupiter.api.Test;

import static app.zoftwhere.combinatoric.Generator.newPermutation;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberBlockTest {

    @Test
    void testSumTotal() {
        final var rowTotal = new int[] {3, 8};
        final var rowCount = rowTotal.length;

        final var columnTotal = new int[] {4, 7};
        final var columnCount = columnTotal.length;

        final var pileArray = new int[] {0, 1, 1, 1, 0, 1};

        final var numberBlock = new NumberBlock(rowTotal, columnTotal, pileArray);

        final var permutation = newPermutation(List.of(1, 2, 3, 5));

        for (var i = 0; i < rowCount; i++) {
            assertEquals(rowTotal[i], numberBlock.sumRow(permutation, i));
        }

        for (var i = 0; i < columnCount; i++) {
            assertEquals(columnTotal[i], numberBlock.sumColumn(permutation, i));
        }
    }

}
