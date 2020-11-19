package HomeWork_3_01.SimpleTasks;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayEditor<T> {

    public static void main(String[] args) {

        Integer[] arr1 = {1,2,3,4,5};
        ArrayEditor<Integer> edI = new ArrayEditor<>();
        edI.changeElements(arr1, 0,4);
        for (int i: arr1) {System.out.print(i);}

        System.out.println("\n-----------");

        ArrayList<Integer> al = edI.convertToList(arr1);
        al.forEach(el -> System.out.print(el));

    }

    public void changeElements(T[] arr, int element_1, int element_2){
        T temp = arr[element_1];
        arr[element_1] = arr[element_2];
        arr[element_2] = temp;
    }

    public ArrayList<T> convertToList(T[] arr) {
        ArrayList<T> arrList = new ArrayList<>();
        Collections.addAll(arrList, arr);
        return arrList;
    }
}
