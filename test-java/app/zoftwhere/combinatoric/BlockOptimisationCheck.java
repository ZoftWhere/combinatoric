package app.zoftwhere.combinatoric;

class BlockOptimisationCheck {

    public static void main(String[] args) {
        final var rowTotal = new int[] {15, 15, 15};
        final var columnTotal = new int[] {15, 15, 15};
        final var pileArray = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        final var optimisationTest = new BlockOptimisation(rowTotal, columnTotal, pileArray);
        final var pair = optimisationTest.testBlockSolutions();
        final var iterationCount = (long) pair.getLeft();
        final var found = pair.getRight().size();

        System.out.printf("Solutions found: %d%n", found);
        System.out.printf("Iterations completed: %d%n", iterationCount);
    }

}
