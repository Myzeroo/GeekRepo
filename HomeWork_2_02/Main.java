package HomeWork_2_02;

public class Main {
    public static void main(String[] args) {

        String[][] myArray = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        //String[][] myArray = {{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        //String[][] myArray = {{"1","2","3"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        //String[][] myArray = {{"1","2","3","4"},{"5","6","7","8"},{"9","d","11","12"},{"13","14","15","16"}};

        System.out.println(VerifyArray.checkArray(myArray));

    }
}
