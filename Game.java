public class Game {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private String result;

    public Game() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        result = "遊戲進行中";

        // 初始化棋盤
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // 設定棋子位置 (row, col 從 0 開始)
    public boolean set(int row, int col) {
        if (gameOver || row < 0 || row > 2 || col < 0 || col > 2) {
            return false; // 無效操作
        }
        if (board[row][col] != ' ') {
            return false; // 該位置已被使用
        }

        board[row][col] = currentPlayer;
        evaluate();
        if (!gameOver) {
            // 換下一位玩家
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    // 判斷遊戲狀態
    private void evaluate() {
        // 檢查橫排與直排
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                gameOver = true;
                result = board[i][0] + " 勝利";
                return;
            }
            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                gameOver = true;
                result = board[0][i] + " 勝利";
                return;
            }
        }

        // 檢查斜線
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            gameOver = true;
            result = board[0][0] + " 勝利";
            return;
        }
        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            gameOver = true;
            result = board[0][2] + " 勝利";
            return;
        }

        // 檢查是否平手
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    full = false;
                }
            }
        }

        if (full) {
            gameOver = true;
            result = "平手";
        }
    }

    public String getResult() {
        return result;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char[][] getBoard() {
        return board;
    }
}
