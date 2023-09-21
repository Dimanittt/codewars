package Codewars;

import java.util.TreeSet;


class DoubleLinear_kata_4kyu {

    public static void main(String[] args) {
        System.out.println(dblLinear(0));
    }

    public static int dblLinear(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(1);
        for (int i = 0; i <= n; i++) {
            int temp = set.first();
            set.add(2 * temp + 1);
            set.add(3 * temp + 1);
            set.remove(temp);
        }
        return set.first();
    }
}
