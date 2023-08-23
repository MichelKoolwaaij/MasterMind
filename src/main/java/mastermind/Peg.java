package mastermind;

import java.util.Random;

/**
 * Created by Michel Koolwaaij on 21-02-19.
 */
public class Peg {
    private PegColor color;

    public Peg(char c) {
        switch (c) {
        case 'B':
            color = PegColor.BLUE;
            break;
        case 'W':
            color = PegColor.WHITE;
            break;
        case 'R':
            color = PegColor.RED;
            break;
        case 'G':
            color = PegColor.GREEN;
            break;
        case 'Z':
            color = PegColor.BLACK;
            break;
        case 'Y':
            color = PegColor.YELLOW;
            break;
        }
    }

    public Peg() {
        color = getRandomColor();
    }

    private PegColor getRandomColor() {
        PegColor[] colors = PegColor.values();
        Random random = new Random();
        return (colors[random.nextInt(colors.length)]);
    }

    public PegColor getColor() {
        return color;
    }
}
