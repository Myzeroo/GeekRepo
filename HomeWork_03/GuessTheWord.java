package HomeWork_03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        System.out.println("Угадай загаданное компьютером слово");
        String сompWord = getWordOutOfArray(words);

        while (true) {
            String userWord = getUserWord();
            String hint = "";

            if (userWord.equals(сompWord)) {
                System.out.println("Ответ верный");
                break;
            } else {
                hint = getMatchedLetters(сompWord, userWord);
                System.out.println("Не верно, подсказка " + hint + " попробуй еще раз.");
            }
        }
    }

    static String getWordOutOfArray(String[] arr) {
        int indexWord = new Random().nextInt(arr.length);
        return arr[indexWord];
    }

    static String getUserWord(){
        System.out.println("Введи слово");
        String userWord = new Scanner(System.in).nextLine();
        userWord = userWord.toLowerCase();
        return userWord;
    }

    static String getMatchedLetters(String сompWord, String userWord) {
        String result = "";
        int сompWordLength = сompWord.length();
        int userWordLength = userWord.length();
        int minLenght = сompWordLength < userWordLength ? сompWordLength : userWordLength;
        int count = minLenght < 15 ? 15 : minLenght;

        for (int i = 0; i < count; i++) {
            if (i < minLenght && сompWord.charAt(i) == userWord.charAt(i)) {
                result += сompWord.charAt(i);
            }else{
                result += "#";
            }
        }
        return result;
    }
}




