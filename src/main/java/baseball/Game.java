package baseball;

import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    private static final int continueGame = 1;
    private static final int baseballNumberLength = 3;
    public static int[] answerNumber = new int[baseballNumberLength];

    private void initConfig() {
        Input inputClass = new Input();
        inputClass.setRandomValue(answerNumber);

    }

    public void run() {
        int isContinue = continueGame;

        while (isContinue == continueGame) {
            initConfig();
            isContinue = 0;
        }
    }
}
