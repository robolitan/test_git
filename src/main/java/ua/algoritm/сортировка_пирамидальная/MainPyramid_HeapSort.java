package ua.algoritm.сортировка_пирамидальная;

import java.util.Arrays;


/**
 * O(n log n)
 * В лучшем и хужших случаях данная сортировка будет иметь сложность ,
 * Выстраиваем массив (дерево), чтобы каждый узел был больше любого из своих потомков (или меньше, если min-heap)
 * массив имеет структуру в котором каждый индекс отображает узел (узлы нумируются с 0, слева направо).
 * Когда выстраиваем отсортированный
 * массив, мы просто берем первый, меняем его с последним, отсекаем. Проверяем корректность расположения корневого узла (heapify, если нужно)
 * повторяем
 *
 * */

public class MainPyramid_HeapSort {
    public static void main(String[] args) {
        int [] testData = {6,8,4,3,2,1,7,10};
        sortPyramid(testData);
        System.out.println(Arrays.toString(testData));
    }
    public static void sortPyramid(int arr[])
    {
        int n = arr.length;
        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2
        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}
