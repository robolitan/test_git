package ua.algoritm.сортировка_шела;

import java.util.Arrays;

/**
 * Смысл в том, чтобы иметь шаг (n/2 с каждой новой вверхней итерацией)(который уменьшит вероятность того, что в конце будут
 * маленькие числа), а потом свести это просто к сортировке вставкой (O(n^2), better O(n*log n))
 */

public class MainShell {
    public static void main(String[] args) {
        int[] testData = {10, 9, 8, 7, 11, 12, 1};
        sortShell(testData);
//        sort(testData);
        System.out.println(Arrays.toString(testData));
    }

    private static void sortShell(int[] testData) {
        int n = testData.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int upperIndex = gap; upperIndex < n; upperIndex++) {
                int key = testData[upperIndex];
                int previous = upperIndex;
                while (previous >= gap && testData[previous - gap] > key) {
                    testData[previous] = testData[previous - gap];
                    previous -= gap;
                }
                testData[previous] = key;
            }
        }
    }


//
//
//
//
//
//
//
//
//
//
//
//


//    public static void sort(int arrayToSort[]) {
//        int n = arrayToSort.length;
//
//        for (int gap = n / 2; gap > 0; gap /= 2) {
//            for (int i = gap; i < n; i++) {
//                int key = arrayToSort[i];
//                int j = i;
//                while (j >= gap && arrayToSort[j - gap] > key) {
//                    arrayToSort[j] = arrayToSort[j - gap];
//                    j -= gap;
//                }
//                arrayToSort[j] = key;
//            }
//        }
//    }
}










