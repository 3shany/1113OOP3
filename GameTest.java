import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

    @Test
    public void testXWinsHorizontally() {
        Game game = new Game();
        game.set(0, 0); // X
        game.set(1, 0); // O
        game.set(0, 1); // X
        game.set(1, 1); // O
        game.set(0, 2); // X wins

        assertTrue(game.isGameOver());
        assertEquals("X 勝利", game.getResult());
    }

    @Test
    public void testOWinsDiagonally() {
        Game game = new Game();
        game.set(0, 0); // X
        game.set(0, 2); // O
        game.set(1, 0); // X
        game.set(1, 1); // O
        game.set(2, 1); // X
        game.set(2, 0); // O wins

        assertTrue(game.isGameOver());
        assertEquals("O 勝利", game.getResult());
    }

    @Test
    public void testDraw() {
        Game game = new Game();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(0, 2); // X
        game.set(1, 1); // O
        game.set(1, 0); // X
        game.set(1, 2); // O
        game.set(2, 1); // X
        game.set(2, 0); // O
        game.set(2, 2); // X → draw

        assertTrue(game.isGameOver());
        assertEquals("平手", game.getResult());
    }

    @Test
    public void testInvalidMove() {
        Game game = new Game();
        assertTrue(game.set(0, 0));
        assertFalse(game.set(0, 0)); // 重複下在同一格
    }
}
