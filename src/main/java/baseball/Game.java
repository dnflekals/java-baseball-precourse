package baseball;

public class Game {

    private static final int continueGame = 1;
    private static final int baseballNumberLength = 3;
    private static final int strike = 0;
    private static final int ball = 1;
    private static final int nothing = 2;
    public static int[] answerNumber = new int[baseballNumberLength];
    public static int[] inputNumber = new int[baseballNumberLength];
    private int[] StrikeBallNothingArray;

    private void initConfig(){
        SettingRandomNumber settingRandomNumber = new SettingRandomNumber();
        settingRandomNumber.setRandomValue(answerNumber);
    }

    private void gaming(){
        while(true){
            setNumber();
            compareTwoArray();
            boolean isEndGame = endGame();
            if(isEndGame) break;
        }
    }

    private void setNumber() {
        SettingNumber settingNumber = new SettingNumber();
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

    private boolean endGame() {
        if (StrikeBallNothingArray[strike] == 3) {
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        int isContinue = continueGame;

        while (isContinue == continueGame) {
            initConfig();
            gaming();
            break;
        }
    }
}
