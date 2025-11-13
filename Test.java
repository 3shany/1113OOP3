import org.junit.Assert;

public class Test {

    @Test
    public void testXWinsHorizontally() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(1, 0); // O
        game.set(0, 1); // X
        game.set(1, 1); // O
        game.set(0, 2); // X wins

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("X 勝利", game.getResult());
    }

    @Test
    public void testOWinsDiagonally() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 2); // O
        game.set(1, 0); // X
        game.set(1, 1); // O
        game.set(2, 1); // X
        game.set(2, 0); // O wins

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("O 勝利", game.getResult());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(0, 2); // X
        game.set(1, 1); // O
        game.set(1, 0); // X
        game.set(1, 2); // O
        game.set(2, 1); // X
        game.set(2, 0); // O
        game.set(2, 2); // X → draw

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("平手", game.getResult());
    }

    @Test
    public void testInvalidMove() {
        TicTacToe game = new TicTacToe();
        Assert.assertTrue(game.set(0, 0));
        Assert.assertFalse(game.set(0, 0)); // 重複下在同一格
    }
}
