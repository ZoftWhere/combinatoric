package example;

import java.math.BigInteger;

import app.zoftwhere.combinatoric.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>Tic Tac Toe Example.
 * </p>
 * <p>Calculates how many positions there are for a 5x5 tic-tac-toe board.
 * </p>
 * <p>Note that this is just the upper-bound as it doesn't check for position validity.
 * </p>
 *
 * @author Osmund
 * @since 3.0.0
 */
class TicTacToeExample {

    @Test
    void test3x3() {
        assertEquals(6046, permutationCount(3).longValue());
    }

    @Test
    void test4x4() {
        assertEquals(10_165_779, permutationCount(4).longValue());
    }

    @Test
    void test5x5() {
        assertEquals(161_995_031_226L, permutationCount(5).longValue());
    }

    private BigInteger permutationCount(int size) {
        final int squareCount = size * size;
        final int enemyMax = squareCount / 2;

        BigInteger total = BigInteger.ZERO;
        for (int enemy = 0; enemy <= enemyMax; enemy++) {
            for (int friendly = enemy; friendly <= enemy + 1; friendly++) {
                final int space = squareCount - enemy - friendly;

                if (space >= 0) {
                    BigInteger count = Calculator.nCr(space + enemy, enemy)
                        .multiply(Calculator.nCr(squareCount, friendly));
                    total = total.add(count);
                }
            }
        }

        return total;
    }

}
