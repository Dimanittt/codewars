package Codewars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mixing_kata_4kyu {
    public static void main(String[] args) {
        System.out.println(mix("codewars", "codewars"));
    }

    public static String mix(String s1, String s2) {
        if (s1.equals("") && s2.equals("")) return "";
        Map<Character, Integer> mapOf_s1 = new HashMap<>();
        Map<Character, Integer> mapOf_s2 = new HashMap<>();
        List<String> list_s1 = new ArrayList<>();
        List<String> list_s2 = new ArrayList<>();

        getMapFromString(s1, mapOf_s1);
        getMapFromString(s2, mapOf_s2);

        getMapAsList(mapOf_s1, list_s1);
        getMapAsList(mapOf_s2, list_s2);
        List<String> transit = new ArrayList<>();


        list_s1.stream().forEach(x -> {
            list_s2.stream().forEach(y -> {
                if (x.charAt(0) == y.charAt(0)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (x.length() > y.length()) {
                        stringBuilder.append("1:" + x);
                        transit.add(stringBuilder.toString());
                    } else if (y.length() > x.length()) {
                        stringBuilder.append("2:" + y);
                        transit.add(stringBuilder.toString());
                    } else {
                        stringBuilder.append("=:" + x);
                        transit.add(stringBuilder.toString());
                    }
                }
            });
        });
        List<String> transit1 = new ArrayList<>(transit);

        Set<Character> check = new TreeSet<>();
        transit.stream().forEach(x -> {
            check.add(x.charAt(2));
        });

        Set<Character> check1 = new TreeSet<>();
        transit.stream().forEach(x -> {
            check1.add(x.charAt(2));
        });

        list_s1.stream().forEach(x -> {
            if (!check1.contains(x.charAt(0))) {
                transit1.add("1:" + x);
            }
        });

        list_s2.stream().forEach(x -> {
            if (!check.contains(x.charAt(0))) {
                transit1.add("2:" + x);
            }
        });

        List<String> result = new ArrayList<>();
        result = transit1
                .stream()
                .sorted((x,y) -> y.length()-x.length())
                .sorted((x,y) -> {
                    if (x.length() == y.length()){
                        if (x.charAt(0) == '1') return -1;
                        else return 1;
                    } return 0;
                })
                .sorted((x,y) -> {
                    if (x.length() == y.length()) {
                        if (y.charAt(0) == '=') return -1;
                        else return 0;
                    }
                    return 0;
                })
                .sorted((x,y) -> {
                    if (x.charAt(0) == y.charAt(0) && x.length() == y.length()){
                        return x.charAt(2) - y.charAt(2);
                    } return 0;
                })
                .map(x -> {
                    StringBuilder stringBuilder = new StringBuilder(x);
                    stringBuilder.insert(0, "/");
                    return stringBuilder.toString();
                })
                .collect(Collectors.toList());
        StringBuilder str = new StringBuilder();
        for (String s : result){
            str.append(s);
        }

        if (str.length() == 0) return "";
        str.deleteCharAt(0);
        return str.toString();
    }

    private static void getMapFromString(String s1, Map<Character, Integer> mapOf_s1) {
        Stream.of(s1.split("")).forEach(x -> {
            if (Character.isLetter(x.charAt(0)) && Character.isLowerCase(x.charAt(0))) {
                if (mapOf_s1.containsKey(x.charAt(0))) {
                    int count = mapOf_s1.get(x.charAt(0));
                    mapOf_s1.put(x.charAt(0), count + 1);
                } else mapOf_s1.put(x.charAt(0), 1);
            }
        });
    }

    private static void getMapAsList(Map<Character, Integer> mapOf_s2, List<String> list_s2) {
        for (Map.Entry<Character, Integer> entry : mapOf_s2.entrySet()) {
            if (entry.getValue() > 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < entry.getValue(); i++) {
                    stringBuilder.append(entry.getKey());
                }
                list_s2.add(stringBuilder.toString());
            }
        }
        list_s2.sort((x, y) -> y.length() - x.length());
    }
}

