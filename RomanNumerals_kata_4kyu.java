package Codewars;

import java.util.*;

public class RomanNumerals_kata_4kyu {
    public static void main(String[] args) {
        System.out.println(toRoman(3999));
        System.out.println(fromRoman("XI"));
        for (int i = 1; i < 4001; i++) {
            System.out.println(fromRoman(toRoman(i)));
        }
    }

    public static String toRoman(int n) {
        String number = String.valueOf(n);

        StringBuilder transit = new StringBuilder(number);
        StringBuilder result = new StringBuilder();

        Map<Character, String> dictionary_1000 = new HashMap<>();
        dictionary_1000.put('0', "");
        dictionary_1000.put('1', "M");
        dictionary_1000.put('2', "MM");
        dictionary_1000.put('3', "MMM");

        Map<Character, String> dictionary_100 = new HashMap<>();
        dictionary_100.put('0', "");
        dictionary_100.put('1', "C");
        dictionary_100.put('2', "CC");
        dictionary_100.put('3', "CCC");
        dictionary_100.put('4', "CD");
        dictionary_100.put('5', "D");
        dictionary_100.put('6', "DC");
        dictionary_100.put('7', "DCC");
        dictionary_100.put('8', "DCCC");
        dictionary_100.put('9', "CM");

        Map<Character, String> dictionary_10 = new HashMap<>();
        dictionary_10.put('0', "");
        dictionary_10.put('1', "X");
        dictionary_10.put('2', "XX");
        dictionary_10.put('3', "XXX");
        dictionary_10.put('4', "XL");
        dictionary_10.put('5', "L");
        dictionary_10.put('6', "LX");
        dictionary_10.put('7', "LXX");
        dictionary_10.put('8', "LXXX");
        dictionary_10.put('9', "XC");

        Map<Character, String> dictionary_1 = new HashMap<>();
        dictionary_1.put('0', "");
        dictionary_1.put('1', "I");
        dictionary_1.put('2', "II");
        dictionary_1.put('3', "III");
        dictionary_1.put('4', "IV");
        dictionary_1.put('5', "V");
        dictionary_1.put('6', "VI");
        dictionary_1.put('7', "VII");
        dictionary_1.put('8', "VIII");
        dictionary_1.put('9', "IX");

        while (transit.length() != 4) {
            transit.insert(0, "0");
        }

        if (transit.charAt(0) != '0') {
            result.append(dictionary_1000.get(transit.charAt(0)));
        }

        if (transit.charAt(1) != '0') {
            result.append(dictionary_100.get(transit.charAt(1)));
        }

        if (transit.charAt(2) != '0') {
            result.append(dictionary_10.get(transit.charAt(2)));
        }

        if (transit.charAt(3) != '0') {
            result.append(dictionary_1.get(transit.charAt(3)));
        }

        return result.toString();
    }


    public static int fromRoman(String romanNumeral) {
        int result = 0;
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String test = romanNumeral;

        for (int i = 0; i < decimal.length; i++ ) {
            while (test.indexOf(roman[i]) == 0) {
                result += decimal[i];
                test = test.substring(roman[i].length());
            }
        }
        return result;
    }
}
