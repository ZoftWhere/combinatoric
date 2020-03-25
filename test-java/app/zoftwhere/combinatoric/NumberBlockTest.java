package app.zoftwhere.combinatoric;

import app.zoftwhere.combinatoric.Permutation;
import app.zoftwhere.combinatoric.NumberBlock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static app.zoftwhere.combinatoric.Generator.newPermutation;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberBlockTest {

    @Test
    void testSumTotal() {
        final int[] rowTotal = {3, 8};
        final int rowCount = rowTotal.length;

        final int[] columnTotal = {4, 7};
        final int columnCount = columnTotal.length;

        final int[] pileArray = {0, 1, 1, 1, 0, 1};

        NumberBlock numberBlock = new NumberBlock(rowTotal, columnTotal, pileArray);

        Permutation<Integer> permutation = newPermutation(List.of(1, 2, 3, 5));

        for (int i = 0; i < rowCount; i++) {
            assertEquals(rowTotal[i], numberBlock.sumRow(permutation, i));
        }

        for (int i = 0; i < columnCount; i++) {
            assertEquals(columnTotal[i], numberBlock.sumColumn(permutation, i));
        }
    }

}