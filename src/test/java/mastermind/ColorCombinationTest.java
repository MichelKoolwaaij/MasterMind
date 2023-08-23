package mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Michel Koolwaaij on 12-06-19.
 */
public class ColorCombinationTest {
    @Test
    public void testColorCombination(){
        ColorCombination cc = new ColorCombination("RBGY");

        Peg p[] = cc.getPegs();

        assertEquals (PegColor.RED, p[0].getColor());
        assertEquals (PegColor.BLUE, p[1].getColor());
        assertEquals (PegColor.GREEN, p[2].getColor());
        assertEquals (PegColor.YELLOW, p[3].getColor());
    }

    @Test
    public void testHintCorrect(){
        ColorCombination correct = new ColorCombination("RBGY");
        ColorCombination guess = new ColorCombination("RBGY");

        Hint h = guess.compareWithOther(correct);

        assertEquals(4, h.getCorrect());
        assertEquals(0, h.getSemiCorrect());
    }

    @Test
    public void testHint1SemiCorrect(){
        ColorCombination correct = new ColorCombination("RBGY");
        ColorCombination guess = new ColorCombination("WWYW");

        Hint h = guess.compareWithOther(correct);

        assertEquals(0, h.getCorrect());
        assertEquals(1, h.getSemiCorrect());
    }

    @Test
    public void testRandomColorCombination(){
        ColorCombination cc = new ColorCombination(5);

        Peg p[] = cc.getPegs();

        assertEquals(5, p.length);
    }
}
