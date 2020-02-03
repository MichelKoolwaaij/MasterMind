package mastermind;

import java.util.Scanner;

/**
 * Created by Michel Koolwaaij on 21-02-19.
 */
public class MastermindConsole {

    private MastermindGame game = new MastermindGame();
    private static final String TAKEAGUESS = "Doe een gok:";

    public static void main(String[] args) {
        MastermindConsole mastermindConsole = new MastermindConsole();
        mastermindConsole.play();
    }

    public void play() {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(TAKEAGUESS);
            String guessAsString = scanner.nextLine().toUpperCase();
            game.checkCombination(guessAsString);
            System.out.println(game);
        } while (!game.won());
        scanner.close();
    }
}
