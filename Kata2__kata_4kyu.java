package Codewars;

import java.util.HashMap;
import java.util.Map;

public class Kata2__kata_4kyu {

    public static void main(String[] args) {
        System.out.println(sumStrings("9999999999999999999999999999999", "7"));
    }
    public static String sumStrings(String a, String b) {

        Map<Integer, String> num1 = new HashMap<>();
        Map<Integer, String> num2 = new HashMap<>();
        Map<Integer, String> sum = new HashMap<>();
        num1.put(-1, "0");

        if (a.length() > b.length())
        {
            for (int i = 0; i < a.length(); i++)
            {
                num1.put(i, String.valueOf(a.charAt(i)));
            }
            for (int i = 0; i < b.length(); i++)
            {
                num2.put(i, String.valueOf(b.charAt(i)));
            }
        }
        else
        {
            for (int i = 0; i < b.length(); i++)
            {
                num1.put(i, String.valueOf(b.charAt(i)));
            }
            for (int i = 0; i < a.length(); i++)
            {
                num2.put(i, String.valueOf(a.charAt(i)));
            }
        }

        for (int i = num2.size() - 1, j = num1.size() - 2; i >= 0; i--, j--)
        {
            if (Integer.parseInt(num1.get(i)) > 9)
            {
                num1.put(j, String.valueOf((Integer.parseInt(num1.get(j)) + Integer.parseInt(num2.get(i)))%10));
                num1.put(j-1, String.valueOf((Integer.parseInt(num1.get(j-1)) + 1)));
            }
            else num1.put(j, String.valueOf((Integer.parseInt(num2.get(i)) + Integer.parseInt(num1.get(j)))));
        }
        for (int i = num1.size() - 2; i >= 0; i--)
        {
            if (Integer.parseInt(num1.get(i)) > 9)
            {
                num1.put(i, String.valueOf((Integer.parseInt(num1.get(i)) % 10)));
                num1.put(i-1, String.valueOf((Integer.parseInt(num1.get(i-1)) + 1)));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : num1.entrySet()){
            stringBuilder.append(entry.getValue());
        }
        while (stringBuilder.charAt(0) == '0'){
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.toString();
    }
}