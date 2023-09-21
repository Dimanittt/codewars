package Codewars;

import java.util.*;

class Permutations_kata_4kyu {

    public static void main(String[] args) {
        System.out.println(singlePermutations("abba"));
    }

    public  static String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    public static List<String> singlePermutations(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(shuffle(s));
        }
        List<String> result = new ArrayList<>(set);
        return result;
    }
}

