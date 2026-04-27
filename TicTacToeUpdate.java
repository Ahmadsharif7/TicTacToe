public class TicTacToeUpdate {

    // Method to place symbol on board
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Utility method to print board
    public static void printBoard(char[][] board) {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Initialize board
        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        // Example move (after validation in UC5)
        int row = 1;
        int col = 2;
        char symbol = 'X';

        // Place move
        placeMove(board, row, col, symbol);

        // Display updated board
        printBoard(board);
    }
}