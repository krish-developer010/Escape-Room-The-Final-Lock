package game;

import door.Door;
import item.Clue;
import item.Item;
import java.util.ArrayList;
import java.util.Scanner;
import player.Player;
import puzzle.CodePuzzle;
import puzzle.LogicPuzzle;
import puzzle.Puzzle;
import puzzle.RiddlePuzzle;
import room.Room;

public class Game {
    private Player player;
    private ArrayList<Room> rooms;
    private ArrayList<Puzzle> puzzleList;
    private Door finalDoor;
    private boolean gameOver;
    private boolean gameWon;
    private Scanner scanner;

    public Game(Player player) {
        this.player = player;
        this.rooms = new ArrayList<>();
        this.puzzleList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.gameOver = false;
        this.gameWon = false;
        initializeGame();
    }

    private void initializeGame() {
        createRooms();
        createPuzzles();
        setupDoors();
    }

    private void createRooms() {
        Room room1 = new Room("The Beginning", "A cold stone room glows with a faint blue light. You hear dripping water and distant footsteps. A metal door stands ahead, sealed by a hidden challenge.");
        Room room2 = new Room("The Hidden Chamber", "Dusty shelves line the walls. Strange objects rest on a table: a book, a lantern, a cracked mask, and a locked box. Something here is important.");
        Room room3 = new Room("The Secret Room", "A narrow chamber opens behind a stone wall. The air smells of old parchment. A single pedestal holds a key with an engraved symbol.");
        Room finalRoom = new Room("The Final Lock", "You stand before a massive circular lock. The exit is just beyond it, but the lock requires the truth of everything you learned.");

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(finalRoom);

        player.setCurrentRoom(room1.getName());
    }

    private void createPuzzles() {
        RiddlePuzzle room1Puzzle = new RiddlePuzzle(
                "The First Riddle",
                "I have keys but no locks, space but no room. You can enter, but not go in. What am I?",
                "A keyboard",
                "A keyboard"
        );

        CodePuzzle room2Puzzle = new CodePuzzle(
                "Hidden Box Code",
                "The box reveals a number code. It asks: 4, 8, 12, ?",
                "16",
                "The pattern is +4."
        );

        LogicPuzzle room3Puzzle = new LogicPuzzle(
                "The Logic of Three",
                "A lantern, a cloak, and a key are three objects. The key is not the lantern. The cloak is not the key. Which item is the key?",
                "key",
                "The key is the one that is not the lantern and not the cloak."
        );

        CodePuzzle finalPuzzle = new CodePuzzle(
                "The Final Lock",
                "The lock asks for the final code. Use your clues: the room one riddle gave you a word, the hidden box gave the number 16, and the secret room key was awarded after logic. What is the 4-digit code?",
                "1612",
                "Think of the word from the first room and the final number pattern."
        );

        puzzleList.add(room1Puzzle);
        puzzleList.add(room2Puzzle);
        puzzleList.add(room3Puzzle);
        puzzleList.add(finalPuzzle);

        rooms.get(0).addPuzzle(room1Puzzle);
        rooms.get(1).addPuzzle(room2Puzzle);
        rooms.get(2).addPuzzle(room3Puzzle);
        rooms.get(3).addPuzzle(finalPuzzle);

        Clue clue1 = new Clue("The Blue Note", "A small paper with a hidden message.", "The answer is a keyboard.");
        Clue clue2 = new Clue("Hidden Vault Note", "A scrap of parchment with a pattern.", "The lock code pattern continues by 4.");
        Clue clue3 = new Clue("Crystal Key", "A silver key engraved with a star.", "You have the key for the next door.");

        rooms.get(0).addItem(clue1);
        rooms.get(1).addItem(clue2);
        rooms.get(2).addItem(clue3);

        puzzleList.get(0).setSolved(false);
        puzzleList.get(1).setSolved(false);
        puzzleList.get(2).setSolved(false);
        puzzleList.get(3).setSolved(false);
    }

    private void setupDoors() {
        finalDoor = new Door("Final Escape Door");
        finalDoor.setRequiredKey("Crystal Key");
        finalDoor.setRequiredPuzzleName("The Final Lock");
    }

    public void startGame() {
        System.out.println("\nA mysterious trapdoor opens. You step into the chamber...");
        System.out.println("Your task: escape all rooms, solve each puzzle, collect clues, and unlock the final door.");

        while (!gameOver) {
            playCurrentRoom();
        }

        showFinalSummary();
    }

    private void playCurrentRoom() {
        Room currentRoom = getCurrentRoom();
        currentRoom.displayRoomInfo();

        if (currentRoom.getName().equals("The Beginning")) {
            handleRoom1();
        } else if (currentRoom.getName().equals("The Hidden Chamber")) {
            handleRoom2();
        } else if (currentRoom.getName().equals("The Secret Room")) {
            handleRoom3();
        } else if (currentRoom.getName().equals("The Final Lock")) {
            handleFinalRoom();
        }
    }

    private Room getCurrentRoom() {
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(player.getCurrentRoom())) {
                return room;
            }
        }
        return rooms.get(0);
    }

    private void handleRoom1() {
        Puzzle puzzle = rooms.get(0).getPuzzle("The First Riddle");
        System.out.println("Puzzle: " + puzzle.getQuestion());

        String answer = askForInput("Your answer: ");
        if (puzzle.solve(answer)) {
            System.out.println("Correct! You receive a hidden clue and the first key to the mystery.");
            player.addScore(20);
            player.addItem(new Clue("Blue Cipher", "A clue with a hidden message.", "The answer was keyboard."));
            rooms.get(0).setCompleted(true);
            player.setCurrentRoom("The Hidden Chamber");
            System.out.println("You move to the Hidden Chamber.");
        } else {
            player.subtractScore(5);
            System.out.println("Wrong answer. The room hums loudly, and the puzzle remains.");
            if (puzzle.getAttempts() >= 3) {
                System.out.println("The room seems to punish you. You lose 10 points.");
                player.subtractScore(10);
            }
        }
    }

    private void handleRoom2() {
        System.out.println("You inspect the objects: a book, a lantern, a cracked mask, and a locked box.");
        System.out.println("Which object would you like to inspect? (book / lantern / mask / box)");
        String choice = askForInput("Choice: ");

        if (choice.equalsIgnoreCase("box")) {
            Puzzle puzzle = rooms.get(1).getPuzzle("Hidden Box Code");
            System.out.println(puzzle.getQuestion());
            String answer = askForInput("Enter the number: ");
            if (puzzle.solve(answer)) {
                System.out.println("The box opens. Inside lies a clue and a note: 'The first answer gave you the key to knowledge.'");
                player.addScore(25);
                player.addItem(new Clue("Vault Clue", "A note with a pattern.", "The pattern is +4, leading to 16."));
                rooms.get(1).setCompleted(true);
                player.setCurrentRoom("The Secret Room");
                System.out.println("You move to the Secret Room.");
            } else {
                player.subtractScore(7);
                System.out.println("The box stays shut. The pattern does not match.");
            }
        } else {
            System.out.println("You search the object but find nothing useful. The room feels colder.");
            player.subtractScore(2);
        }
    }

    private void handleRoom3() {
        Puzzle puzzle = rooms.get(2).getPuzzle("The Logic of Three");
        System.out.println("Puzzle: " + puzzle.getQuestion());
        String answer = askForInput("Your answer: ");

        if (puzzle.solve(answer)) {
            System.out.println("Correct. A hidden compartment opens and you recover a silver key.");
            player.addScore(30);
            player.addItem(new Item("Crystal Key", "A silver key marked with a star."));
            rooms.get(2).setCompleted(true);
            player.setCurrentRoom("The Final Lock");
            System.out.println("You move to the Final Lock.");
        } else {
            player.subtractScore(8);
            System.out.println("The pedestal remains silent. The logic is not complete.");
        }
    }

    private void handleFinalRoom() {
        System.out.println("The door demands an answer. The lock glows with a final challenge.");
        System.out.println("Use what you learned in the previous rooms.");
        Puzzle puzzle = rooms.get(3).getPuzzle("The Final Lock");
        System.out.println(puzzle.getQuestion());
        String answer = askForInput("Final code: ");

        if (puzzle.solve(answer)) {
            if (finalDoor.unlock(player, answer, puzzle.isSolved())) {
                System.out.println("The final door unlocks with a deep rumble.");
                player.addScore(50);
                gameWon = true;
                gameOver = true;
            } else {
                System.out.println("The lock rejects the code. You have not gathered enough truth yet.");
                player.subtractScore(12);
            }
        } else {
            player.subtractScore(10);
            System.out.println("Wrong code. The lock trembles and resets.");
        }
    }

    private String askForInput(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        if (input == null) {
            return "";
        }
        return input.trim();
    }

    private void showFinalSummary() {
        System.out.println("\n====================================");
        System.out.println("         FINAL SCORE SUMMARY");
        System.out.println("====================================");
        System.out.println("Player: " + player.getName());
        System.out.println("Final score: " + player.getScore());
        player.displayInventory();

        if (gameWon) {
            System.out.println("Congratulations! You escaped the room and solved the Final Lock!");
        } else {
            System.out.println("The chamber defeats you. Better luck next time.");
        }
    }
}
