package baseball;

public class Game {

    private static final int continueGame = 1;
    private static final int baseballNumberLength = 3;
    public static int[] answerNumber = new int[baseballNumberLength];
    public static int[] inputNumber = new int[baseballNumberLength];
    private int[] StrikeBallNothingArray;

    private void setNumber() {
        SettingNumber settingNumber = new SettingNumber();
        settingNumber.setRandomValue(answerNumber);
        while (true) {
            boolean isValidation = settingNumber.setInputValue(inputNumber);
            if (isValidation) {
                break;
            }
            System.out.println("You have entered an invalid number. Please input it again.");
        }
    }

    private void compareTwoArray() {
        CompareNumber compareNumber = new CompareNumber();
        StrikeBallNothingArray = compareNumber.getCompareNumber(answerNumber, inputNumber);
    }

    public void run() {
        int isContinue = continueGame;

        while (isContinue == continueGame) {
            setNumber();
            compareTwoArray();
            isContinue = 0;
        }
    }
}
