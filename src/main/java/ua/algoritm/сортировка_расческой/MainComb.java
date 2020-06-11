package ua.algoritm.сортировка_расческой;

import java.util.Arrays;

/**
 * Еще одна модификация сортировки пузырьком. Для того, чтобы избавиться от «черепах»,
 * будем переставлять элементы, стоящие на расстоянии. Зафиксируем его и будем идти слева направо,
 * сравнивая элементы, стоящие на этом расстоянии, переставляя их, если необходимо. Очевидно,
 * это позволит «черепахам» быстро добраться в начало массива. Оптимально изначально
 * взять расстояние равным длине массива, а далее делить его на некоторый коэффициент, равный примерно 1.247.
 * Когда расстояние станет равно единице, выполняется сортировка пузырьком. В лучшем случае асимптотика равна O(n*logn), в худшем – O(n^2).
 * Какая асимптотика в среднем мне не очень понятно, на практике похоже на O(n*logn). */

public class MainComb {
    public static void main(String[] args) {
        int[] testArray = {1231, 24324, 5, 35, 23, 5, 32, 1};
        combSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    private static void combSort(int[] testArray) {
        int start, end, tmp, gap;
        gap = testArray.length;
        boolean sorted = false;
        while (gap != 1 || !sorted) {
            testArray = testArray;
            gap = max(1, (int) (gap - 1));
            sorted = true;
            for (int i = 0; i < testArray.length - gap; i++) {
                int j = i + gap;
                if (testArray[i] > testArray[j]) {
                    tmp = testArray[i];
                    testArray[i] = testArray[j];
                    testArray[j] = tmp;
                    sorted = false;
                }
            }
        }
    }

    private static int max(int gap, int v) {
        return gap < v ? v : gap;
    }
}
