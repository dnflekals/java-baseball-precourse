package baseball;

public class CompareNumber {

    private static final int baseballNumberLength = 3;
    private static final int strike = 0;
    private static final int ball = 1;
    private static final int nothing = 2;

    protected int[] getCompareNumber(int[] answerNumber, int[] inputNumber) {
        // 0번째 index: strike, 1번째 index: ball, 2번째 index: nothing
        int StrikeBallNothingArray[] = new int[baseballNumberLength];

        for (int i = 0; i < baseballNumberLength; i++) {
            boolean isAddStrike = addStrike(StrikeBallNothingArray, answerNumber, inputNumber, i);
            boolean isAddBall = addBall(StrikeBallNothingArray, answerNumber, inputNumber, i);
            if (isAddStrike == false && isAddBall == false) {
                StrikeBallNothingArray[nothing]++;
            }
        }

        return StrikeBallNothingArray;
    }

    private boolean addStrike(int[] StrikeBallNothingArray, int[] answerNumber, int[] inputNumber,
        int index) {
        if (answerNumber[index] == inputNumber[index]) {
            StrikeBallNothingArray[strike]++;
            return true;
        }
        return false;
    }

    private boolean addBall(int[] StrikeBallNothingArray, int[] answerNumber, int[] inputNumber,
        int index) {
        for (int i = 0; i < baseballNumberLength; i++) {
            if (index == i) {
                continue;
            }
            if (answerNumber[index] == inputNumber[i]) {
                StrikeBallNothingArray[ball]++;
                return true;
            }
        }
        return false;
    }
}
