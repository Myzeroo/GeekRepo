package HomeWork_08;

public abstract class Сalculate {
    static String result;

    static String getResult(String textOutput) {

        String str = textOutput;
        int startIndx = 0;
        String mathOperation;
        int[] digits = new int[0];
        String[] operations = new String[0];
        int endIndx = 0;

        int lngh = str.length();

        // обрезаем лишние знаки
        str = str.startsWith("+") ? str = str.substring(1) : str;
        str = str.startsWith("-") ? str = str.substring(1) : str;
        str = str.endsWith("+") ? str = str.substring(0, str.length() - 1) : str;
        str = str.endsWith("-") ? str = str.substring(0, str.length() - 1) : str;

        // в цикле разбиваем оставшийся тескт на цифры и прифметические операции
        for (int i = 0; startIndx < lngh; i++) {

            int pIndx = str.indexOf("+", startIndx);
            int mIndx = str.indexOf("-", startIndx);

            if (((pIndx < mIndx) && (pIndx != -1)) || mIndx == -1) {
                mathOperation = "+";
                endIndx = pIndx;
            } else {
                mathOperation = "-";
                endIndx = mIndx;
            }

            endIndx = endIndx != -1 ? endIndx : str.length();
            // записываем числа
            int digitVal = Integer.parseInt(str.substring(startIndx, endIndx));

            int[] tmpArr = new int[digits.length + 1];
            System.arraycopy(digits, 0, tmpArr, 0, digits.length);
            digits = tmpArr;
            digits[digits.length - 1] = digitVal;

            if (pIndx == -1 && mIndx == -1) break;
            // записываем арифметические знаки
            String[] tmpA = new String[operations.length + 1];
            System.arraycopy(operations, 0, tmpA, 0, operations.length);
            operations = tmpA;
            operations[operations.length - 1] = mathOperation;

            startIndx = endIndx + 1;
        }

        // производим вычисления
        int result = digits[0];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "+":
                    result += digits[i + 1];
                    break;
                case "-":
                    result -= digits[i + 1];
                    break;
            }
        }

        return String.valueOf(result);
    }
}
