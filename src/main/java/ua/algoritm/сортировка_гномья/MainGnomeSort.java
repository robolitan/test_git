package ua.algoritm.сортировка_гномья;

import java.util.Arrays;


/**
 *
 * Проходим по массиву. Берем второй, сравниваем с первым. Если больше первый, то меняем. Индекс уменьшаем на 1 и так до конца.
 * Если больше второй, то увеличиваем счетчик пока не дойдем до размера массива
 *
 * */

public class MainGnomeSort {
    public static void main(String[] args) {
        int[] testData = {9, 8, 7, 6, 54, 3, 2, 1};
        gnomeSort(testData);
        System.out.println(Arrays.toString(testData));
    }

    private static void gnomeSort(int[] testData) {
        int index, size, tmp;
        index = 1;
        size = testData.length;
        while (index < size) {
            if (testData[index - 1] > testData[index]){
                swap(testData, index);
                if(index > 1) {
                    index--;
                }
            }else {
                index++;
            }
        }
    }

    private static void swap(int [] arr, int index) {
        int tmp = arr[index];
        arr[index] = arr[index - 1];
        arr[index - 1] = tmp;
    }
}
