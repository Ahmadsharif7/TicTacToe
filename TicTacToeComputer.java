import java.util.Random;

public class TicTacToeComputer {

    // Reuse: slot → row & col
    public static int[] getRowCol(int slot) {
        int index = slot - 1;
        int row = index / 3;
        int col = index % 3;
        return new int[]{row, col};
    }

    // Reuse: validation
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == '-');
    }

    // Reuse: place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Print board
    public static void printBoard(char[][] board) {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC7: Computer move
    public static void computerMove(char[][] board, char symbol) {

        Random random = new Random();
        int slot, row, col;

        while (true) {
            slot = random.nextInt(9) + 1; // 1–9

            int[] pos = getRowCol(slot);
            row = pos[0];
            col = pos[1];

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, symbol);
                System.out.println("🤖 Computer chose slot: " + slot);
                break;
            }
        }
    }

    public static void main(String[] args) {

        // Sample board
        char[][] board = {
            {'X', '-', '-'},
            {'-', 'O', '-'},
            {'-', '-', '-'}
        };

        printBoard(board);

        // Computer plays 'O'
        computerMove(board, 'O');

        printBoard(board);
    }
}