package Codewars;

import java.util.Arrays;

public class Snail_kata_4kyu {

    public static int[] snail(int[][] array) {
        if (array.length == 1) {
            try {
                int[] nul = new int[1];
                nul[0] = array[0][0];
                return nul;
            } catch (ArrayIndexOutOfBoundsException e) {
                return new int[0];
            }
        }
        int[] result = new int[array[0].length * array[1].length];
        int toRightMin = 0;
        int toRightMax = array[1].length - 1;
        int toDownMin = 1;
        int toDownMax = array[0].length - 1;
        int toLeftMin = array[1].length - 2;
        int toLeftMax = 0;
        int toUpMin = array[0].length - 2;
        int toUpMax = 1;
        int count = 1;
        while (count < (array[0].length * array[1].length + 1)) {
            for (int i = toRightMin; i <= toRightMax; i++) {
                result[count - 1] = array[toRightMin][i];
                count++;
            }
            toRightMin++;
            toRightMax--;
            for (int i = toDownMin; i <= toDownMax; i++) {
                result[count - 1] = array[i][toDownMax];
                count++;
            }
            toDownMin++;
            toDownMax--;
            for (int i = toLeftMin; i >= toLeftMax; i--) {
                result[count - 1] = array[toLeftMin + 1][i];
                count++;
            }
            toLeftMin--;
            toLeftMax++;
            for (int i = toUpMin; i >= toUpMax; i--) {
                result[count - 1] = array[i][toUpMax - 1];
                count++;
            }
            toUpMin--;
            toUpMax++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] array = new int[0][0];
//        int[] result = new int[array[0].length*array[1].length];
        int[] result = new int[0];


//        for (int i = 0; i < array[0].length; i++) {
//            for (int j = 0; j < array[1].length; j++) {
//                array[i][j] = i+j;
//            }
//        }
//        printArray(array);
        System.out.println();
//        array[0][0] = 1;
        result = snail(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(result));
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                System.out.print(array[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }
}