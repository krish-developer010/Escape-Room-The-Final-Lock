package puzzle;

public abstract class Puzzle {
    private String name;
    private String question;
    private String hint;
    private boolean solved;
    private int attempts;

    public Puzzle(String name, String question, String hint) {
        this.name = name;
        this.question = question;
        this.hint = hint;
        this.solved = false;
        this.attempts = 0;
    }

    public abstract boolean solve(String answer);

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public String getHint() {
        return hint;
    }

    public boolean isSolved() {
        return solved;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void incrementAttempts() {
        attempts++;
    }

    public void displayHint() {
        System.out.println("Hint: " + hint);
    }
}
