package ua.algoritm.сортировка_глупая;

import java.util.Arrays;


/**
 * Сложность O(n^3)
 *
 * */
public class MainStupid {
    public static void main(String[] args) {
        int[] testData = {9,8,7,5,3,2,2};
        stupidSort(testData);
        System.out.println(Arrays.toString(testData));

    }

    private static void stupidSort(int[] testData) {
        int tmp, index = 1;
        boolean sorted = false;
        while (index < testData.length) {
            if (testData[index - 1] > testData[index]) {
               tmp = testData[index];
               testData[index] = testData[index - 1];
               testData[index - 1] = tmp;
                index = 1;
            } else {
                index++;
            }
        }
    }
}
