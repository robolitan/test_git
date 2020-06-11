package ua.algoritm.сортировка_шейкерная;

import java.util.Arrays;

/**
 * Также известна как сортировка перемешиванием и коктейльная сортировка.
 * Заметим, что сортировка пузырьком работает медленно на тестах, в которых маленькие
 * элементы стоят в конце (их еще называют «черепахами»). Такой элемент на каждом шаге алгоритма
 * будет сдвигаться всего на одну позицию влево. Поэтому будем идти не только слева направо, но и справа налево.
 * Будем поддерживать два указателя begin и end, обозначающих, какой отрезок массива еще не отсортирован.
 * На очередной итерации при достижении end вычитаем из него единицу и движемся справа налево, аналогично,
 * при достижении begin прибавляем единицу и двигаемся слева направо. Асимптотика у алгоритма такая же,
 * как и у сортировки пузырьком, однако реальное время работы лучше.*/

public class MainShaker {
    public static void main(String[] args) {
        int[] testData = {12, 3, 2, 312, 4, 4, 565, 6, 78234, 12, 2, 98};
        sortShaker(testData);
        System.out.println(Arrays.toString(testData));
    }

    private static void sortShaker(int[] testData) {
        int tmp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < testData.length - 1; i++) {
                if (testData[i] > testData[i + 1]) {
                    tmp = testData[i];
                    testData[i] = testData[i + 1];
                    testData[i + 1] = tmp;
                    sorted = false;
                }
            }
            for (int i = testData.length - 1; i > 0; i--) {
                if (testData[i] < testData[i - 1]) {
                    tmp = testData[i];
                    testData[i] = testData[i - 1];
                    testData[i - 1] = tmp;
                    sorted = false;
                }
            }
        }
    }
}
