package room;

import item.Item;
import java.util.ArrayList;
import puzzle.Puzzle;

public class Room {
    private String name;
    private String description;
    private ArrayList<Puzzle> puzzles;
    private ArrayList<Item> items;
    private boolean completed;
    private String exitDescription;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.puzzles = new ArrayList<>();
        this.items = new ArrayList<>();
        this.completed = false;
        this.exitDescription = "There is an exit to continue.";
    }

    public void addPuzzle(Puzzle puzzle) {
        puzzles.add(puzzle);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getExitDescription() {
        return exitDescription;
    }

    public void setExitDescription(String exitDescription) {
        this.exitDescription = exitDescription;
    }

    public void displayRoomInfo() {
        System.out.println("\n========================================");
        System.out.println("Room: " + name);
        System.out.println("========================================");
        System.out.println(description);

        if (!items.isEmpty()) {
            System.out.println("Items in this room:");
            for (Item item : items) {
                System.out.println("- " + item.getName() + " - " + item.getDescription());
            }
        }

        if (!puzzles.isEmpty()) {
            System.out.println("Puzzles in this room:");
            for (Puzzle puzzle : puzzles) {
                System.out.println("- " + puzzle.getName());
            }
        }

        System.out.println(exitDescription);
    }

    public boolean hasPuzzle(String puzzleName) {
        for (Puzzle puzzle : puzzles) {
            if (puzzle.getName().equalsIgnoreCase(puzzleName)) {
                return true;
            }
        }
        return false;
    }

    public Puzzle getPuzzle(String puzzleName) {
        for (Puzzle puzzle : puzzles) {
            if (puzzle.getName().equalsIgnoreCase(puzzleName)) {
                return puzzle;
            }
        }
        return null;
    }
}
