package mastermind;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michel Koolwaaij on 21-02-19.
 */
public class ColorCombination {

    private Peg[] pegs;

    public ColorCombination(String guessAsString) {

        pegs = new Peg[guessAsString.length()];
        for (int i = 0; i < guessAsString.length(); i++) {
            pegs[i] = new Peg(guessAsString.charAt(i));
        }
    }

    public ColorCombination(int nrOfPegs) {
        pegs = new Peg[nrOfPegs];

        for (int i = 0; i < nrOfPegs; i++) {
            pegs[i] = new Peg();
        }
    }

    public Hint compareWithOther(ColorCombination other) {
        Hint hint = new Hint();
        hint.setCorrect(determineRightColorRightPosition(other));
        hint.setSemiCorrect(determineRightColorWrongPosition(other));
        return hint;
    }

    private int determineRightColorRightPosition(ColorCombination other) {
        int count = 0;
        for (int i = 0; i < other.pegs.length; i++) {

            if (other.pegs[i].getColor() == pegs[i].getColor()) {
                count++;
            }
        }
        return count;
    }

    private int determineRightColorWrongPosition(ColorCombination other) {
        int count = 0;

        ArrayList<Peg> guessed = new ArrayList<>();
        ArrayList<Peg> comb = new ArrayList<>();
        // First filter the good guesses
        for (int i = 0; i < other.pegs.length; i++) {

            if (other.pegs[i].getColor() != pegs[i].getColor()) {
                guessed.add(other.pegs[i]);
                comb.add(pegs[i]);
            }
        }

        // Now check the other guesses.
        // We only want to compare the remaining guesses and pegs
        // When found remove the peg from the remaining list
        for (Peg guess: guessed){
            boolean found = false;
            for (Iterator<Peg> iterator = comb.iterator(); iterator.hasNext();) {
                Peg peg = iterator.next();
                if ((peg.getColor() == guess.getColor()) && !found) {
                    count++;
                    iterator.remove();
                    found = true;
                }
            }
        }

        return count;
    }

    public Peg[] getPegs() {
        return pegs;
    }
}
