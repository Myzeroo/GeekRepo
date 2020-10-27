package HomeWork_08;

public class Test {
    public static void main(String[] args) {

        String str = "1+1+1-1-";
        int startIndx = 0;
        String mathOperation;
        int[] digits = new int[0];
        String[] operations = new String[0];
        int endIndx = 0;

        int lngh = str.length();

        // обрезаем знаки
        str = str.startsWith("+") ? str = str.substring(1) : str;
        str = str.startsWith("-") ? str = str.substring(1) : str;
        str = str.endsWith("+") ? str = str.substring(0, str.length() - 1) : str;
        str = str.endsWith("-") ? str = str.substring(0, str.length() - 1) : str;

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

            int digitVal = Integer.parseInt(str.substring(startIndx, endIndx));

            int[] tmpArr = new int[digits.length + 1];
            System.arraycopy(digits, 0, tmpArr, 0, digits.length);
            digits = tmpArr;
            digits[digits.length - 1] = digitVal;

            if (pIndx == -1 && mIndx == -1) break;

            String[] tmpA = new String[operations.length + 1];
            System.arraycopy(operations, 0, tmpA, 0, operations.length);
            operations = tmpA;
            operations[operations.length - 1] = mathOperation;

            startIndx = endIndx + 1;
        }

        int result = digits[0];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]){
                case "+":
                    result += digits[i+1];
                    break;
                case "-":
                    result -= digits[i+1];
                    break;
            }
        }
        System.out.println(result);

    }
}
