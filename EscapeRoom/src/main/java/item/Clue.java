package item;

public class Clue extends Item {
    private String clueText;

    public Clue(String name, String description, String clueText) {
        super(name, description);
        this.clueText = clueText;
    }

    public String getClueText() {
        return clueText;
    }

    public void setClueText(String clueText) {
        this.clueText = clueText;
    }
}
