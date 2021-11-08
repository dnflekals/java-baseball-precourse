package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import utils.RandomUtils;

public class Input {

    private static final int baseballNumberLength = 3;
    private Scanner scanner = new Scanner(System.in);
    private Set<Integer> set = new HashSet<>();

    protected void setRandomValue(int[] answerNumber) {
        set.clear();
        int countRandomValue = 0;

        while (countRandomValue < baseballNumberLength) {
            int num = RandomUtils.nextInt(1, 9);

            if (!set.contains(num)) {
                set.add(num);
                answerNumber[countRandomValue] = num;
                countRandomValue++;
            }
        }
    }

    protected boolean setInputValue(int[] inputNumber) {
        String inputString = scanner.nextLine();
        boolean isValidation = validationInputNumber(inputString);
        if (isValidation == false) {
            return false;
        }

        int inputValue = Integer.parseInt(inputString);
        boolean isDuplicated = checkDuplicatedNumber(inputValue);
        if (isDuplicated == false) {
            return false;
        }

        for (int i = baseballNumberLength - 1; i >= 0; i--) {
            inputNumber[i] = inputValue % 10;
            inputValue /= 10;
        }

        return true;
    }

    private boolean validationInputNumber(String inputString) {
        String[] strArray = inputString.split("");
        for (String s : strArray) {
            if (s.charAt(0) <= '0' || s.charAt(0) > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicatedNumber(int inputValue) {
        set.clear();
        int countInputValue = 0;

        while (countInputValue < baseballNumberLength) {
            int num = inputValue % 10;
            inputValue /= 10;

            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            countInputValue++;
        }
        return true;
    }
}
