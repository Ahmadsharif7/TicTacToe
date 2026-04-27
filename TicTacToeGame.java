import java.util.Scanner;
import java.util.Random;

public class TicTacToeGame {

    // Print board
    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Slot → row,col
    public static int[] getRowCol(int slot) {
        int index = slot - 1;
        return new int[]{index / 3, index % 3};
    }

    // Validate move
    public static boolean isValidMove(char[][] board, int r, int c) {
        return r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == '-';
    }

    // Place move
    public static void placeMove(char[][] board, int r, int c, char symbol) {
        board[r][c] = symbol;
    }

    // Check win
    public static boolean checkWin(char[][] b, char s) {

        // rows & cols
        for (int i = 0; i < 3; i++) {
            if ((b[i][0] == s && b[i][1] == s && b[i][2] == s) ||
                (b[0][i] == s && b[1][i] == s && b[2][i] == s)) {
                return true;
            }
        }

        // diagonals
        if ((b[0][0] == s && b[1][1] == s && b[2][2] == s) ||
            (b[0][2] == s && b[1][1] == s && b[2][0] == s)) {
            return true;
        }

        return false;
    }

    // Check draw
    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    // Computer move
    public static void computerMove(char[][] board, char symbol) {
        Random rand = new Random();
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int[] pos = getRowCol(slot);
            if (isValidMove(board, pos[0], pos[1])) {
                placeMove(board, pos[0], pos[1], symbol);
                System.out.println("🤖 Computer chose slot: " + slot);
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialize board
        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        char currentPlayer = 'X'; // X = human, O = computer
        boolean gameRunning = true;

        System.out.println("🎮 Tic-Tac-Toe Game Start!");

        while (gameRunning) {

            printBoard(board);

            if (currentPlayer == 'X') {
                // Human move
                int slot;
                while (true) {
                    System.out.print("Enter slot (1-9): ");
                    slot = sc.nextInt();

                    int[] pos = getRowCol(slot);
                    if (isValidMove(board, pos[0], pos[1])) {
                        placeMove(board, pos[0], pos[1], 'X');
                        break;
                    } else {
                        System.out.println("❌ Invalid move! Try again.");
                    }
                }
            } else {
                // Computer move
                computerMove(board, 'O');
            }

            // Check win
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("🏆 Player " + currentPlayer + " wins!");
                gameRunning = false;
                break;
            }

            // Check draw
            if (isDraw(board)) {
                printBoard(board);
                System.out.println("🤝 It's a draw!");
                gameRunning = false;
                break;
            }

            // Switch turn
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}