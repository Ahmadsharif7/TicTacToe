public class TicTacToeWinCheck {

    // Method to check if a player has won
    public static boolean checkWin(char[][] board, char symbol) {

        // 1. Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // 2. Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        // 3. Check diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false; // no win found
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', 'X', 'X'},
            {'-', 'O', '-'},
            {'O', '-', '-'}
        };

        char currentPlayer = 'X';

        if (checkWin(board, currentPlayer)) {
            System.out.println("🏆 Player " + currentPlayer + " wins!");
        } else {
            System.out.println("No winner yet.");
        }
    }
}