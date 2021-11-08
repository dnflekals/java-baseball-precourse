package baseball;

import java.util.HashSet;
import java.util.Set;
import utils.RandomUtils;

public class SettingRandomNumber {

    private Set<Integer> set = new HashSet<>();

    protected void setRandomValue(int[] answerNumber) {
        set.clear();
        int countRandomValue = 0;

        int baseballNumberLength = 3;
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
