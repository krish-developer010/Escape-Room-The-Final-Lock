package door;

import player.Player;

public class Door {
    private String name;
    private boolean locked;
    private String requiredKey;
    private String requiredCode;
    private String requiredPuzzleName;

    public Door(String name) {
        this.name = name;
        this.locked = true;
        this.requiredKey = null;
        this.requiredCode = null;
        this.requiredPuzzleName = null;
    }

    public String getName() {
        return name;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setRequiredKey(String requiredKey) {
        this.requiredKey = requiredKey;
    }

    public void setRequiredCode(String requiredCode) {
        this.requiredCode = requiredCode;
    }

    public void setRequiredPuzzleName(String requiredPuzzleName) {
        this.requiredPuzzleName = requiredPuzzleName;
    }

    public String getRequiredKey() {
        return requiredKey;
    }

    public String getRequiredCode() {
        return requiredCode;
    }

    public String getRequiredPuzzleName() {
        return requiredPuzzleName;
    }

    public boolean canUnlock(Player player, String enteredCode, boolean puzzleSolved) {
        boolean keyCondition = true;
        boolean codeCondition = true;
        boolean puzzleCondition = true;

        if (requiredKey != null && !requiredKey.isEmpty()) {
            keyCondition = player.hasItem(requiredKey);
        }

        if (requiredCode != null && !requiredCode.isEmpty()) {
            codeCondition = enteredCode != null && enteredCode.equalsIgnoreCase(requiredCode);
        }

        if (requiredPuzzleName != null && !requiredPuzzleName.isEmpty()) {
            puzzleCondition = puzzleSolved;
        }

        return keyCondition && codeCondition && puzzleCondition;
    }

    public boolean unlock(Player player, String enteredCode, boolean puzzleSolved) {
        if (canUnlock(player, enteredCode, puzzleSolved)) {
            locked = false;
            return true;
        }
        return false;
    }

    public void displayDoorStatus() {
        if (locked) {
            System.out.println("The " + name + " is locked.");
        } else {
            System.out.println("The " + name + " is unlocked.");
        }
    }
}
