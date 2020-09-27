package HomeWork_03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {

        do {
            plaуInGame();
        }
        while (continueGame());
    }

    static void plaуInGame() {
        int randomNumber = new Random().nextInt(10);
        int attempts = 3;
        System.out.println("Угадайте число, введите от 0 до 9");

        boolean resultGame = guessingNumber(attempts, randomNumber);

        if (resultGame) {
            System.out.println("Поздравляем вы угадали");
        } else {
            System.out.println("Вы проиграли, было загадано число " + randomNumber);
        }
    }

    static boolean guessingNumber(int attempts, int hiddenNubber) {
        for (int i = 0; i < attempts; i++) {
            int userAnswer = new Scanner(System.in).nextInt();
            if (userAnswer == hiddenNubber) {
                return true;
            } else if (userAnswer < hiddenNubber) {
                System.out.println("Загаданное число больше ");
            } else if (userAnswer > hiddenNubber) {
                System.out.println("Загаданное число меньше ");
            }
        }
        return false;
    }

    static boolean continueGame() {
        int userAnswer;
        do {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            userAnswer = new Scanner(System.in).nextInt();
        }
        while (userAnswer > 1 || userAnswer < 0);

        if (userAnswer == 1) {
            return true;
        } else {
            return false;
        }
    }
}

