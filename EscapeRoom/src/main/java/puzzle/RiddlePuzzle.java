package puzzle;

public class RiddlePuzzle extends Puzzle {
    private String correctAnswer;

    public RiddlePuzzle(String name, String question, String hint, String correctAnswer) {
        super(name, question, hint);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean solve(String answer) {
        incrementAttempts();

        if (answer == null) {
            return false;
        }

        String cleanedAnswer = answer.trim();

        if (cleanedAnswer.equalsIgnoreCase(correctAnswer)) {
            setSolved(true);
            return true;
        }

        return false;
    }
}
