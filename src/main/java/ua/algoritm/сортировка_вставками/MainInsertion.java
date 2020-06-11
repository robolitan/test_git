package ua.algoritm.сортировка_вставками;


import java.util.Arrays;

/**
 * Суть в том, чтобы брать элемент к примеру 2(индекс 1) в массиве, и пробегать влево до тех пор пока не найдем место,
 * куда данные елемент нужно вставить (где он меньше остальных по правую сторону). O(n^2)
 */
public class MainInsertion {
    public static void main(String[] args) {
        int[] testData = {7,5,3,11};
        insertionSort(testData);
        System.out.println(Arrays.toString(testData));
    }

    private static void insertionSort(int[] testData) {
        int current;
        testData = testData;
        for (int i = 1; i < testData.length; i++) {
            current = testData[i];
            int j = i - 1;
            while ( j >= 0 && current < testData[j]){
                testData[j+1] = testData[j];
                j--;
            }
            testData[j + 1] = current;
        }
    }
}
