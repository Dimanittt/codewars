package Codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kata1_kata_4kyu {
    public static String justify(String text, int width) {
        String[] words = text.split(" ");
        if (text.equals("")) return text;
        if (words.length == 1) return words[0];
        List<String> listOfWords = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[0]);
        words[0] = "";
        for (String s : words) {
            if ((stringBuilder.length() + s.length() + 1) < width) {
                if (stringBuilder.length() >= 1 && stringBuilder.length() != width) {
                    if (stringBuilder.charAt(stringBuilder.length()-1) == ' ') stringBuilder.append(s);
                    else stringBuilder.append(' ' + s);
                }
            } else {
                listOfWords.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                stringBuilder.append(s);
            }
        }

        listOfWords = listOfWords.stream().map(row -> {
            String[] check = row.split(" ");
            if (check.length == 1) return row;
            StringBuilder stringBuilder1 = new StringBuilder(row);
            while (stringBuilder1.length() != width) {
                for (int i = 1; i < stringBuilder1.length(); i++) {
                    if (stringBuilder1.charAt(i) == ' ' && stringBuilder1.charAt(i-1) != ' ' && stringBuilder1.length() != width) {
                        stringBuilder1.insert(i, ' ');
                        i++;
                    }
                }
            }
            return stringBuilder1.toString();
        }).collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        for (String s : listOfWords) {
            result.append(s).append("\n");
        }
        result.append(stringBuilder);
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis dolor mauris, at elementum ligula tempor  eget. In quis rhoncus nunc, at aliquet orci. Fusce at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. Vivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, non dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at fermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum velit ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellentesque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla et dolor.";
        int width = 60;
        System.out.println(justify(text, width));
    }
}