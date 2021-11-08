package baseball;

import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    private static final int continueGame = 1;
    private static final int baseballNumberLength = 3;
    public static int[] answerNumber = new int[baseballNumberLength];
    public static int[] inputNumber = new int[baseballNumberLength];

    private void setNumber() {
        Input inputClass = new Input();
        inputClass.setRandomValue(answerNumber);
        while (true) {
            boolean isValidation = inputClass.setInputValue(inputNumber);
            if (isValidation) {
                break;
            }
            System.out.println("You have entered an invalid number. Please input it again.");
        }
    }

    public void run() {
        int isContinue = continueGame;

        while (isContinue == continueGame) {
            setNumber();
            isContinue = 0;
        }
    }
}
