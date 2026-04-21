import java.util.Random;

public class TicTacToeToss {

    public static void main(String[] args) {

        // 1. Create Random object
        Random random = new Random();

        // 2. Generate toss (0 or 1)
        int toss = random.nextInt(2);

        // 3. Game state variables
        String player1 = "Player 1";
        String player2 = "Player 2";

        char player1Symbol;
        char player2Symbol;
        String currentPlayer;
        char currentSymbol;

        // 4. Conditional logic for assignment
        if (toss == 0) {
            player1Symbol = 'X';
            player2Symbol = 'O';
            currentPlayer = player1;
            currentSymbol = player1Symbol;
        } else {
            player1Symbol = 'O';
            player2Symbol = 'X';
            currentPlayer = player2;
            currentSymbol = player2Symbol;
        }

        // 5. Display results
        System.out.println("🎲 Toss Result Completed!\n");

        System.out.println(player1 + " Symbol: " + player1Symbol);
        System.out.println(player2 + " Symbol: " + player2Symbol);

        System.out.println("\n👉 " + currentPlayer + " will start first!");
        System.out.println("👉 Starting Symbol: " + currentSymbol);
    }
}