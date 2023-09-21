package Codewars;

import java.util.ArrayList;
import java.util.List;

public class Josephus_kata_5kyu {

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("true");
        test.add("false");
        test.add("true");
        test.add("false");
        test.add("true");
        test.add("false");
        test.add("true");
        test.add("false");
        test.add("true");
        System.out.println(josephusPermutation(test, 9));
        System.out.println("[true, true, true, false, false, true, false, true, false]");
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        int i = k - 1;
        if (i >= items.size() && !items.isEmpty()){
            i = i % items.size();
        }
        List<T> finalList = new ArrayList<>();
        if (items.isEmpty()) return items;
        while (!items.isEmpty()) {
            finalList.add(items.get(i));
            System.out.println(finalList);
            int indexOfTtoDelete = i;
            i = i + k - 1;
            items.remove(indexOfTtoDelete);
            if (i >= items.size() && !items.isEmpty()){
                i = i % items.size();
            }
        }
        return finalList;
    }
}