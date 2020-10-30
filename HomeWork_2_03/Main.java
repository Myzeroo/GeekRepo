package HomeWork_2_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> setWords = new ArrayList<>();
        setWords.add("Вилка");
        setWords.add("Палка");
        setWords.add("Колесо");
        setWords.add("Тарелка");
        setWords.add("Сифон");
        setWords.add("Коса");
        setWords.add("Дом");
        setWords.add("Колодка");
        setWords.add("Вилка");
        setWords.add("Палка");
        setWords.add("Оса");
        setWords.add("Палка");
        setWords.add("Дом");

        Collections.sort(setWords);

        String prevWords = setWords.get(0);
        int count = 1;

        for (int i = 1; i < setWords.size(); i++) {
            if (setWords.get(i) == prevWords) {
                count++;
                continue;
            }
            System.out.println(prevWords + " " + count);
            prevWords = setWords.get(i);
            count = 1;
        }
    }
}
