package baseball;

public class CompareNumber {

    private static final int BASEBALL_MAX_NUMBER = 3;
    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int NOTHING = 2;

    protected int[] getCompareNumber(int[] answerNumber, int[] inputNumber) {
        // 0번째 index: strike, 1번째 index: ball, 2번째 index: nothing
        int StrikeBallNothingArray[] = new int[BASEBALL_MAX_NUMBER];

        for (int i = 0; i < BASEBALL_MAX_NUMBER; i++) {
            boolean isAddStrike = addStrike(StrikeBallNothingArray, answerNumber, inputNumber, i);
            boolean isAddBall = addBall(StrikeBallNothingArray, answerNumber, inputNumber, i);
            if (isAddStrike == false && isAddBall == false) {
                StrikeBallNothingArray[NOTHING]++;
            }
        }

        return StrikeBallNothingArray;
    }

    private boolean addStrike(int[] StrikeBallNothingArray, int[] answerNumber, int[] inputNumber,
        int index) {
        if (answerNumber[index] == inputNumber[index]) {
            StrikeBallNothingArray[STRIKE]++;
            return true;
        }
        return false;
    }

    private boolean addBall(int[] StrikeBallNothingArray, int[] answerNumber, int[] inputNumber,
        int index) {
        for (int i = 0; i < BASEBALL_MAX_NUMBER; i++) {
            if (index == i) {
                continue;
            }
            if (answerNumber[index] == inputNumber[i]) {
                StrikeBallNothingArray[BALL]++;
                return true;
            }
        }
        return false;
    }
}
