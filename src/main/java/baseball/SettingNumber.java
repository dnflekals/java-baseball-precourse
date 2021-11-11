package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import utils.RandomUtils;

public class SettingNumber {

    private static final int BASEBALL_MAX_NUMBER = 3;
    private Scanner scanner = new Scanner(System.in);
    private Set<Integer> set = new HashSet<>();

    protected void setInputValue(int[] inputNumber) {
        String inputString = scanner.nextLine();
        if (inputString.length() < BASEBALL_MAX_NUMBER
            || inputString.length() > BASEBALL_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }

        boolean isValidation = validationInputNumber(inputString);
        if (isValidation == false) {
            throw new IllegalArgumentException();
        }

        int inputValue = Integer.parseInt(inputString);
        boolean isDuplicated = checkDuplicatedNumber(inputValue);
        if (isDuplicated == false) {
            throw new IllegalArgumentException();
        }

        for (int i = BASEBALL_MAX_NUMBER - 1; i >= 0; i--) {
            inputNumber[i] = inputValue % 10;
            inputValue /= 10;
        }
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

        while (countInputValue < BASEBALL_MAX_NUMBER) {
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
