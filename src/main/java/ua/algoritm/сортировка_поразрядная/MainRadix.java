package ua.algoritm.сортировка_поразрядная;

import java.util.Arrays;

/**
 * O(n*m, где m - разряность числа)Логика проста. Нам нужно сравнивать от меньших до старших разрядов числа,
 * класть в новый массив, продолжать пока не отсортируем.
 */

public class MainRadix {
    public static void main(String[] args) {
        int[] testData = {5, 3, 9, 11, 4, 70, 332};
        radixSort(testData);
        System.out.println(Arrays.toString(testData));
    }

    private static void radixSort(int[] testData) {
        int countDigit = countDigit(testData);
        int radixCount[][] = new int[9][testData.length];
        int x = 0;
        while (countDigit > 0) {
            for (int i = 0; i < testData.length; i++) {
                testData[i] = 0;
            }
            countDigit--;
        }
    }


    private static int countDigit(int[] testData) {
        int maxValue = testData[0];
        int countDigit = 0;
        for (int i = 0; i < testData.length; i++) {
            if (maxValue < testData[i]) {
                maxValue = testData[i];
            }
        }
        while (maxValue > 0) {
            countDigit++;
            maxValue /= 10;
        }
        return countDigit;
    }

//
//    radix sort
//    public static void radixSort(int[] arr) {
//        int cnt[][] = new int[4][];
//        int b[];
//        int i, j;
//        int a_len = arr.length;
//        // инициализируем счетчик [cnt]
//        for (j = 0; j < 4; j++) {
//            cnt[j] = new int[257];
//            for (i = 0; i < 257; i++) cnt[j][i] = 0;
//        }
//        // выделяем память под копию сортируемого массива
//        b = new int[a_len];
//
//        // подсчитываем количество элементов для каждого значения j-го разряда
//        for (i = 0; i < a_len; i++) {
//            for (j = 0; j < 4; j++) {
//                cnt[j][1 + ((arr[i] >>> (8 * j)) & 0xff)]++;
//            }
//        }
//
//        for (j = 0; j < 4; j++) {
//        /*
//            вычисляем позиции cnt[i], начиная с которых будут располаться элементы
//            с соответствующим значением j-го разряда
//        */
//            for (i = 1; i < 256; i++) cnt[j][i] += cnt[j][i - 1];
//            // расставляем элементы из массива a в массив b в указанном порядке
//            for (i = 0; i < a_len; i++) {
//                b[cnt[j][(arr[i] >>> (8 * j)) & 0xff]++] = arr[i];
//            }
//// копируем массив b на место массива a
//            for (i = 0; i < a_len; i++) arr[i] = b[i];
//        }
//    }
}
