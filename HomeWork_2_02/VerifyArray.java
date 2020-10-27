package HomeWork_2_02;

public class VerifyArray {

    public static int checkArray(String[][] myArr) {
        /* check size */
        if (myArr.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (String[] arr : myArr) {
                if (arr.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        /* end check size */

        /* convert to int and summarize */
        int summ =0;
        for (int i = 0; i<myArr.length; i++){
            for (int j=0;j<myArr[i].length; j++){
                try{
                    summ+=Integer.parseInt(myArr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("\n" + e.getMessage() + "\n не число в ячейке ["+ (i+1) + "][" + (j+1) +"]" );
                }
            }
        }
        return summ;
    }
}
