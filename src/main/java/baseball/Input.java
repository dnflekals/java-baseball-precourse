package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import utils.RandomUtils;

public class Input {

    private static final int baseballNumberLength = 3;

    public void setRandomValue(int[] answerNumber) {
        Set<Integer> set = new HashSet<>();
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
}
