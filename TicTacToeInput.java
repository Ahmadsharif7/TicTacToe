import java.util.Scanner;

public class TicTacToeInput {

    // Method to read and return a valid slot (1–9)
    public static int getUserSlot(Scanner scanner) {
        int slot;

        while (true) {
            System.out.print("Enter a slot number (1-9): ");

            if (scanner.hasNextInt()) {
                slot = scanner.nextInt();

                if (slot >= 1 && slot <= 9) {
                    return slot; // valid input
                } else {
                    System.out.println("❌ Invalid! Choose a number between 1 and 9.");
                }
            } else {
                System.out.println("❌ Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Call method to get user input
        int selectedSlot = getUserSlot(scanner);

        // Return control to game logic (for now just print)
        System.out.println("✅ You selected slot: " + selectedSlot);

        scanner.close();
    }
}