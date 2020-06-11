package ua.algoritm.сортировка_подсчетом;

import java.util.Arrays;


/**
 * Алгоритм имеет сложность  O(n*k), где k - максимальное значение переменной.
 * суть в том, чтобы создать массим размером max-min+1, заполнить вхождения,
 * суммировать в данном массиве предыдущие значения и затем искать изменения (1,1,1,1,'2')
 * и записывать
 * текущий индекс, как значение в исходный массив
 */

public class MainCounter {
    public static void main(String[] args) {
        int[] testData = {8, 7, 5, 3, 2, 1,1, 4};
        sortCount(testData, testData.length);
        System.out.println(Arrays.toString(testData));
    }

    private static void sortCount(int[] testData, int length) {
        int minMax[] = getMinMax(testData);
        int min, max;
        min = minMax[0];
        max = minMax[1];
        int range = max - min + 1;
        int counter[] = new int[range];

        for (int i = 0; i < length; i++) {
            counter[testData[i] - min]++;
        }
        for (int i = 1; i < range; i++) {
            counter[i] += counter[i - 1];
        }
        int j = 0;
        for(int i = 0; i < range; i++){
            while (j < counter[i]){
                testData[j++] = i + min;
            }
        }
    }

    private static int[] getMinMax(int[] unsortedArray) {
        int[] minMax = new int[2];
        for (int i = 0; i < unsortedArray.length; i++) {
            if (minMax[1] < unsortedArray[i]) minMax[1] = unsortedArray[i];
            if (minMax[0] > unsortedArray[i]) minMax[0] = unsortedArray[i];
        }
        return minMax;
    }
//
//
//
//
//
//
//
//    public static void sortCount(int[] input, int n) {
//        int min = 0, max = 0;
//        for (int i = 1; i < n; i++) {
//            if (input[i] > max)
//                max = input[i];
//            if (input[i] < min)
//                min = input[i];
//        }
//        int range = max - min + 1;
//        int[] count = new int[range];
//        //counts frequencies for each element
//        for (int i = 0; i < n; i++)
//            count[input[i] - min]++;
//        // getting positions in final array
//        for (int i = 1; i < range; i++)
//            count[i] += count[i - 1];
//        //copy to output array, preserving order of inputs with equal keys
//        int j = 0;
//        for (int i = 0; i < range; i++)
//            while (j < count[i])
//                input[j++] = i + min;
//    }
}
