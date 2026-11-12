package puzzle;

public class CodePuzzle extends Puzzle {
    private String correctCode;

    public CodePuzzle(String name, String question, String hint, String correctCode) {
        super(name, question, hint);
        this.correctCode = correctCode;
    }

    @Override
    public boolean solve(String answer) {
        incrementAttempts();

        if (answer == null) {
            return false;
        }

        String cleanedAnswer = answer.trim();

        if (cleanedAnswer.equalsIgnoreCase(correctCode)) {
            setSolved(true);
            return true;
        }

        return false;
    }
}
