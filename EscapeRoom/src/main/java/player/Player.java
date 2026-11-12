package player;

import item.Item;
import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private String currentRoom;
    private ArrayList<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.currentRoom = "Start";
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public void addScore(int points) {
        score += points;
    }

    public void subtractScore(int points) {
        score = Math.max(0, score - points);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println("- " + item.getName() + " : " + item.getDescription());
        }
    }
}
