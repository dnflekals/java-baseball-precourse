package baseball;

import java.util.Scanner;

public class Game {

    private static final int CONTINUE_GAME = 1;
    private static final int BASEBALL_MAX_NUMBER = 3;
    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int NOTHING = 2;
    public static int[] answerNumber = new int[BASEBALL_MAX_NUMBER];
    public static int[] inputNumber = new int[BASEBALL_MAX_NUMBER];
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
        settingNumber.setInputValue(inputNumber);
    }

    private void compareTwoArray() {
        CompareNumber compareNumber = new CompareNumber();
        StrikeBallNothingArray = compareNumber.getCompareNumber(answerNumber, inputNumber);
    }

    private boolean endGame() {
        if (StrikeBallNothingArray[STRIKE] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            showMessage();
            return false;
        }
    }

    private void showMessage() {
        if (StrikeBallNothingArray[NOTHING] == BASEBALL_MAX_NUMBER) {
            System.out.println("낫싱");
        } else if (StrikeBallNothingArray[STRIKE] == 0) {
            System.out.println(StrikeBallNothingArray[BALL] + "볼");
        } else if (StrikeBallNothingArray[BALL] == 0) {
            System.out.println(StrikeBallNothingArray[STRIKE] + "스트라이크");
        } else {
            System.out.println(
                StrikeBallNothingArray[BALL] + "볼" + " " + StrikeBallNothingArray[STRIKE]
                    + "스트라이크");
        }
    }

    private boolean regame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int isRegame = scanner.nextInt();
            if (isRegame == 1) {
                return true;
            } else if (isRegame == 2) {
                return false;
            }
            System.out.println("올바른 숫자를 입력해주세요.");
        }
    }

    public void run() {
        int isContinue = CONTINUE_GAME;

        while (isContinue == CONTINUE_GAME) {
            initConfig();
            gaming();
            boolean isRegame = regame();
            if (isRegame == false) {
                break;
            }
        }
    }
}
