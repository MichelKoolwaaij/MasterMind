package mastermind;

/**
 * Created by Michel Koolwaaij on 21-02-19.
 */
public class ColorCombination {


    private Peg[] pegs;

    public ColorCombination(String guessAsString) {

        pegs = new Peg[guessAsString.length()];
        for (int i=0; i<guessAsString.length();i++){
            pegs[i]=new Peg(guessAsString.charAt(i));
        }

    }

    public ColorCombination(int nrOfPegs){
        pegs = new Peg[nrOfPegs];
        PegColor k;

        for (int i=0; i<nrOfPegs;i++){
            pegs[i]=new Peg();
        }

    }

    public Hint compareWithOther (ColorCombination other){
        Hint hint = new Hint();
        hint.setCorrect(determineRightColorRightPosition(other));
        hint.setSemiCorrect(determineRightColorWrongPosition(other));
        return hint;

    }

    private int determineRightColorRightPosition(ColorCombination other){
        int aantal=0;
        for (int i=0; i<other.pegs.length;i++){
            if (other.pegs[i].getColor() == pegs[i].getColor()){
                aantal ++;
            }
        }
        return aantal;
    }

    private int determineRightColorWrongPosition(ColorCombination other){
        int aantal=0;
        boolean[] gehad = new boolean[pegs.length];
        for (int i=0; i<gehad.length;i++){
            gehad[i] = false;
        }

        for (int i=0; i<other.pegs.length;i++){
            for(int j=0; j< other.pegs.length;j++){
                if ((other.pegs[i].getColor()==pegs[j].getColor()) && !gehad[j]){
                    if (j!=i) {
                        aantal++;
                    }
                    gehad[j] = true;
                    break;
                }
            }
        }

        return aantal;

    }
    public Peg[] getPegs() {
        return pegs;
    }

}
