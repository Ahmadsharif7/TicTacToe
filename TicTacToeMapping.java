public class TicTacToeMapping {

    // Utility method to convert slot to row & column
    public static int[] getRowCol(int slot) {

        int index = slot - 1; // convert to 0-based

        int row = index / 3;
        int col = index % 3;

        return new int[]{row, col};
    }

    public static void main(String[] args) {

        int slot = 5; // example input (later comes from UC3)

        int[] position = getRowCol(slot);

        System.out.println("Slot: " + slot);
        System.out.println("Row: " + position[0]);
        System.out.println("Column: " + position[1]);
    }
}