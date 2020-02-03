package mastermind;

/**
 * Created by Michel Koolwaaij on 21-02-19.
 */
public class MastermindGame {
    private ColorCombination guess;
    private ColorCombination secretCode;
    private Hint hint;
    private int turn;
    private boolean won;
    private String state;

    private static final int NROFPEGS = 4;
    private static final String WONINTEXT = "Gewonnen in ";
    private static final String TURNTEXT = " beurten.";
    private static final String NRCORRECT = "Aantal goed: ";
    private static final String NRWRONGPLACE = "Aantal op de verkeerde plaats: ";

    public MastermindGame() {
        turn = 0;
        won = false;
        secretCode = new ColorCombination(NROFPEGS);
    }

    public void checkCombination(String guessAsString) {
        turn++;

        guess = new ColorCombination(guessAsString);
        hint = secretCode.compareWithOther(guess);
        won = hint.getCorrect() == NROFPEGS;

        if (won) {
            state = WONINTEXT + turn + TURNTEXT;
        } else {
            state = NRCORRECT + hint.getCorrect() + "\n" + NRWRONGPLACE + hint.getSemiCorrect();
        }
    }

    public boolean won() {
        return won;
    }

    public String toString() {
        return state;
    }
}
