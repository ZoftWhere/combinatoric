package app.zoftwhere.combinatoric;

public class BlockOptimisationCheck {

    public static void main(String[] args) {
        final int[] rowTotal = {15, 15, 15};
        final int[] columnTotal = {15, 15, 15};
        final int[] pileArray = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        final int[] pileArray = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, -1, -1};
        final var optimisationTest = new BlockOptimisation(rowTotal, columnTotal, pileArray);
        final var pair = optimisationTest.testBlockSolutions();
        final var iterationCount = (long) pair.getLeft();
        final var found = pair.getRight().size();

        System.out.printf("Solutions found: %d%n", found);
        System.out.printf("Iterations completed: %d%n", iterationCount);
    }

}
