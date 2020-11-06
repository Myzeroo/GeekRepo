package HomeWork_2_04.SortTreeMap;

import java.util.Comparator;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        TreeMap<String, Integer> tm1 = new TreeMap<>();
        tm1.put("101", 3);
        tm1.put("-1", 10);
        tm1.put("4", 1);
        Comparator comparator = new MyComparator(tm1);
        TreeMap<String, Integer> tm2 = new TreeMap<>(comparator);
        tm2.putAll(tm1);

        System.out.println(tm2);

    }
}
