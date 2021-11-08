package baseball;

import java.util.Scanner;

public class Game {

    private static final int continueGame = 1;
    private static final int baseballNumberLength = 3;
    private static final int strike = 0;
    private static final int ball = 1;
    private static final int nothing = 2;
    public static int[] answerNumber = new int[baseballNumberLength];
    public static int[] inputNumber = new int[baseballNumberLength];
    private int[] StrikeBallNothingArray;

    private void initConfig() {
        SettingRandomNumber settingRandomNumber = new SettingRandomNumber();
        settingRandomNumber.setRandomValue(answerNumber);
    }

    private void gaming() {
        while (true) {
            setNumber();
            compareTwoArray();
            boolean isEndGame = endGame();
            if (isEndGame) {
                break;
            }
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
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            showMessage();
            return false;
        }
    }

    private void showMessage() {
        if (StrikeBallNothingArray[nothing] == baseballNumberLength) {
            System.out.println("낫싱");
        } else if (StrikeBallNothingArray[strike] == 0) {
            System.out.println(StrikeBallNothingArray[ball] + "볼");
        } else if (StrikeBallNothingArray[ball] == 0) {
            System.out.println(StrikeBallNothingArray[strike] + "스트라이크");
        } else {
            System.out.println(
                StrikeBallNothingArray[ball] + "볼" + " " + StrikeBallNothingArray[strike]
                    + "스트라이크");
        }
    }

    private boolean regame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        while(true){
            int isRegame=scanner.nextInt();
            if(isRegame==1) return true;
            else if(isRegame==2) return false;
            System.out.println("올바른 숫자를 입력해주세요.");
        }
    }

    public void run() {
        int isContinue = continueGame;

        while (isContinue == continueGame) {
            initConfig();
            gaming();
            boolean isRegame = regame();
            if(isRegame==false) break;
        }
    }
}
