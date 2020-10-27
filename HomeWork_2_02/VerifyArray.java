package HomeWork_2_02;

public class VerifyArray {

    static void checkArray(String[][] myArr) {
        if (myArr.length != 4) {
            throw new MyArraySizeException();
        }else{
            for (String[] arr: myArr ) {
                if(arr.length != 4){
                    throw new MyArraySizeException();
                }
            }
        }
    }
}
