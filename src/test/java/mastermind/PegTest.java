package mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Michel Koolwaaij on 12-06-19.
 */
public class PegTest {

    @Test
    public void testYellow(){
        Peg p;

        p = new Peg ('Y');

        assertEquals(PegColor.YELLOW, p.getColor());

    }

    @Test
    public void testEmpty(){
        Peg p;

        p = new Peg ();

        assertTrue(p.getColor().ordinal() > 0);
    }
}
