package HomeWork_04;

import java.util.Random;
import java.util.Scanner;

public class CrossZero {

    static int GFL;  // Сокращение GameField.length
    static String[][] GameField;
    static final String emptySign = "*";
    static final String compSign = "O";
    static final String userSign = "X";
    //int computer = 0;
    //int user = 1;
    static String currentSign = "";
    static int CurrentX;
    static int CurrentY;

    public static void main(String[] args) {

        createGameField();


        do {
            getWhoGoesNext();
            makeMove();
            drawField();
        }
        while (checkNoWinner());
        String winner = currentSign == compSign ? "компьютер" : "пользователь";
        System.out.println("Победу одержал " + winner);
    }

    static void createGameField() {
        System.out.println("Задай размер игрового поля");
        GFL = new Scanner(System.in).nextInt();
        GameField = new String[GFL][GFL];

        for (int i = 0; i < GFL; i++) {
            for (int j = 0; j < GFL; j++) {
                GameField[i][j] = emptySign;
            }
        }
    }

    static void drawField() {

        for (String[] as : GameField) {
            System.out.print("| ");
            for (String str : as) {
                System.out.print(str + " | ");
            }
            System.out.println();
        }
        System.out.println("=====================");
    }

    static void getWhoGoesNext() {
        if (currentSign == compSign) {
            currentSign = userSign;
        } else if (currentSign == userSign) {
            currentSign = compSign;
        } else {                                        // кто ходит первым
            int i = new Random().nextInt(2);
            if (i % 2 == 0) {
                currentSign = compSign;
                System.out.println("Первый ход делает компьютер");
            } else {
                currentSign = userSign;
                System.out.println("Первый ход делает пользователь");
                drawField();
            }
        }
    }

    static void makeMove() {

        if (currentSign == compSign) {
            System.out.println("Ход компьютера");
            getCompСoordinates();
        } else {
            System.out.println("Твой ход");
            getUserСoordinates();
        }
    }

    static void getCompСoordinates() {
        int x;
        int y;
        do {
            x = new Random().nextInt(GFL);
            y = new Random().nextInt(GFL);
        }
        while (IsBusyCell(x, y));
        GameField[x][y] = currentSign;
    }

    static void getUserСoordinates() {
        int x;
        int y;
        boolean repeatInput;

        OUTER:
        do {

            INNER:
            do {
                System.out.println("Введи координату Х");
                x = new Scanner(System.in).nextInt() - 1;
                System.out.println("Введи координату Y");
                y = new Scanner(System.in).nextInt() - 1;

                if (x >= 0 && x < GFL                // значения находятся в пределах массива
                        && y >= 0 && y < GFL)
                {
                    break INNER;
                }
                System.out.println("Значения должны быть от 1 до " + GFL + "\nпопробуй еще раз...");
            }
            while (true);

            repeatInput = IsBusyCell(x, y);
            if (repeatInput) {
                System.out.println("Данная ячейка уже занята, попробуй еще раз");
            }
        }
        while (repeatInput);
        GameField[x][y] = currentSign;
    }

    static boolean IsBusyCell(int x, int y) {
        if (GameField[x][y] == emptySign) {
            return false;
        }
        return true;
    }

    static boolean checkNoWinner() {

        int diagonalALine = 1;
        int diagonalBLine = 1;

        OUTER:
        for (int i = 0; i < GFL; i++) {

            int horizontalLine = 1;
            int verticalLine = 1;

            INNER:
            for (int j = 0; j < GFL; j++) {


                if (j + 1 < GFL) {
                    // Проверка горизонтали
                    if (GameField[i][j] != emptySign // ячейка не пустая
                            && GameField[i][j] == GameField[i][j + 1] // текущий элемент равен следующему по горизонтали
                            && ++horizontalLine == GFL /* при проверке условия, если доходит до сюда, происходит инкремент */
                    ) {
                        return false;
                    }
                    // Проверка вертикали
                    if (GameField[j][i] != emptySign // ячейка не пустая
                            && GameField[j][i] == GameField[j + 1][i] // текущий элемент равен следующему по вертикали
                            && ++verticalLine == GFL) { /* при проверке условия, если доходит до сюда, происходит инкремент */
                        return false;
                    }
                    // Проверка прямой диагонали
                    if (i == j
                            && GameField[i][j] != emptySign // ячейка не пустая
                            && GameField[i][j] == GameField[i + 1][j + 1] // текущий элемент равен следующему по прямой диагонали
                            && ++diagonalALine == GFL /* при проверке условия, если доходит до сюда, происходит инкремент */
                    ) {
                        return false;
                    }
                    // Проверка обратной диагонали
                    if (i == j
                            && GameField[i][GFL - j - 1] != emptySign // ячейка не пустая
                            && GameField[i][GFL - j - 1] == GameField[i + 1][GFL - j - 2] // текущий элемент равен следующему по обратной диагонали
                            && ++diagonalBLine == GFL  /* при проверке условия, если доходит до сюда, происходит инкремент */
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


