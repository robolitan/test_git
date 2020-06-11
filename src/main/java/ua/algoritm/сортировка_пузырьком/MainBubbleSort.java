package ua.algoritm.сортировка_пузырьком;

import java.util.Arrays;

/**
 * Будем идти по массиву слева направо. Если текущий элемент больше следующего, меняем их местами.
 * Делаем так, пока массив не будет отсортирован. Заметим, что после первой итерации самый большой
 * элемент будет находиться в конце массива, на правильном месте. После двух итераций на правильном месте
 * будут стоять два наибольших элемента, и так далее. Очевидно, не более чем после n итераций массив будет
 * отсортирован. Таким образом, асимптотика в худшем и среднем случае – O(n^2), в лучшем случае – O(n).
 */

public class MainBubbleSort {
    public static void main(String[] args) {
        int[] testData = {213, 12, 4, 354, 6, 567, 8, 7, 324, 1, 23};
        System.out.println(Arrays.toString(bubbleSort(testData)));
    }

    private static int [] bubbleSort(int[] testData) {
        int tmp, current, next;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < testData.length - 1; i++) {
                if ((current = testData[i]) > (next = testData[i + 1])) {
                    tmp = current;
                    testData[i] = next;
                    testData[i + 1] = tmp;
                    sorted = false;
                }
            }
        }
        return testData;
    }
}