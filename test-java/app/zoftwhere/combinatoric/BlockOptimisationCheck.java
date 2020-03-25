package app.zoftwhere.combinatoric;

import app.zoftwhere.combinatoric.BlockOptimisation;

public class BlockOptimisationCheck {

    public static void main(String[] args) {
        final int[] rowTotal = {15, 15, 15};
        final int[] columnTotal = {15, 15, 15};
        final int[] pileArray = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        final int[] pileArray = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, -1, -1};
        BlockOptimisation optimisationTest = new BlockOptimisation(rowTotal, columnTotal, pileArray);
        BlockOptimisation.SolutionPair pair = optimisationTest.testBlockSolutions();
        long iterationCount = pair.getLeft();
        int found = pair.getRight().size();

        System.out.printf("Solutions found: %d%n", found);
        System.out.printf("Iterations completed: %d%n", iterationCount);
    }

}
