package HomeWork_2_04.SortTreeMap;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<String> {
    private final Map<String, Integer> mp;

    public MyComparator(Map<String, Integer> mp) {
        this.mp = mp;
    }

    @Override
    public int compare(String o1, String o2) {
        return mp.get(o1) - mp.get(o2);
    }
}
