package main;

import game.Game;
import java.util.Scanner;
import player.Player;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("============================================");
            System.out.println("   ESCAPE ROOM: THE FINAL LOCK");
            System.out.println("============================================");
            System.out.println("1. Start Game");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter your name: ");
                String playerName = scanner.nextLine().trim();

                if (playerName.isEmpty()) {
                    playerName = "Player";
                }

                Player player = new Player(playerName);
                Game game = new Game(player);
                game.startGame();
                break;
            } else if (choice.equals("2")) {
                displayInstructions();
            } else if (choice.equals("3")) {
                System.out.println("Thanks for playing. Goodbye!");
                return;
            } else {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void displayInstructions() {
        System.out.println("\nInstructions:");
        System.out.println("- Explore each room carefully.");
        System.out.println("- Solve the puzzles to unlock progress.");
        System.out.println("- Collect clues and items from the rooms.");
        System.out.println("- Use your inventory and hints wisely.");
        System.out.println("- The final door needs the correct key and final code.");
        System.out.println("- Wrong answers and hints reduce your score.");
        System.out.println("- Escape by solving the Final Lock.");
        System.out.println();
    }
}
