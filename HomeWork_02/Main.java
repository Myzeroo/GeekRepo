package HomeWork_02;

public class Main {

    public static void main(String[] args) {
        // 1 ЗАДАНИЕ ===================================
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) arr1[i] = 0;
            else arr1[i] = 1;
            System.out.print(arr1[i] + ", "); //Проверка
        }
        System.out.println(); //отступ между заданиями

        //2 ЗАДАНИЕ ===================================
        int[] arr2 = new int[8];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
            System.out.print(arr2[i] + ", "); //Проверка
        }
        System.out.println(); //отступ между заданиями

        //3 ЗАДАНИЕ ===================================
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
            System.out.print(arr3[i] + ", "); //Проверка
        }
        System.out.println("\n"); //отступ между заданиями

        //4 ЗАДАНИЕ - заполнить его диагональные элементы единицами (понял как "крестиком")
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j) arr4[i][j] = 1;
                int reverseCount = arr4.length - 1 - i;
                if (reverseCount == j) arr4[i][j] = 1;
            }
        }
        //Проверка
        for (int[] i : arr4) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println(); //отступ между заданиями

        //5 ЗАДАНИЕ ===================================
        int[] arr5 = {7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        int min, max;
        min = max = arr5[0];

        for (int i = 0; i < arr5.length; i++) {
            if (min > arr5[i]) min = arr5[i];
            if (max < arr5[i]) max = arr5[i];
        }
        System.out.println("min = " + min + ", max = " + max); //Проверка


        // проверка задания 6
        int[] arr61 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arr62 = {1, 1, 1, 2, 1};
        int[] arr63 = {2, 2, 2, 2, 3, 2, 2, 2, 2, 2};
        System.out.println(checkBalance(arr61));
        System.out.println(checkBalance(arr62));
        System.out.println(checkBalance(arr63));

        // проверка задания 7
        int[] arr71 = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i : shiftElement(arr71, -2)) {
            System.out.print(i);

        }
    }

    //6 ЗАДАНИЕ ===================================
    static boolean checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            int sumIndex = leftIndex + rightIndex;

            if (sumIndex == arr.length && leftSum == rightSum) return true;

            if (leftSum > rightSum) { //Если "левая сумма" значений больше, то к "правой сумме" прибавить следующее с конца значение увеличив "правый индекс".
                rightSum += arr[arr.length - 1 - rightIndex++];
            } else if (leftSum < rightSum) { // Если "правая сумма" занчений больше, то к "левой сумме" прибавить следующее значение, увеличив "левый индекс".
                leftSum += arr[leftIndex++];
            } else {  // если суммы равны, и к левой и к правой суммам прибавить значения из следующих индексов массива.
                rightSum += arr[arr.length - 1 - rightIndex++];
                leftSum += arr[leftIndex++];
            }
        }
        return false;
    }

    //7 ЗАДАНИЕ ===================================
    static int[] shiftElement(int[] arr, int shift) {

        if(shift >= 0){  // если число положительное сдвигать вправо
            for (int i = 0; i < shift; i++) {
                int lastElement = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = lastElement;
            }
        }else{ // если число отрицательное сдвигать влево
            shift = -shift;
            for (int i = 0; i < shift; i++) {
                int firstElement = arr[0];
                for (int j = 0; j < arr.length-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length - 1] = firstElement;
            }
        }
        return arr;
    }
}

