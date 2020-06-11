package ua.algoritm.сортировка_выбором;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ints = {12, 3, 16, 31, 4,123,44,13,56,12,555};
        getSortedArray(ints);
        System.out.println(Arrays.toString(ints));
    }

    static void getSortedArray(int[] arr) {
        int currentSmallestIndex = 0;
        int currentSmalestElement = 0;
        for (int left = 0; left < arr.length; left++) {
            currentSmallestIndex = left;
            currentSmalestElement = arr[left];
            for (int i = left; i < arr.length; i++) {
                if (arr[i] < currentSmalestElement) {
                    currentSmallestIndex = i;
                    currentSmalestElement = arr[i];
                }
            }
            swap(arr, left, currentSmallestIndex);
        }
    }

    private static void swap(int[] arr, int left, int currentSmallestIndex) {
        int buff = arr[left];
        arr[left] = arr[currentSmallestIndex];
        arr[currentSmallestIndex] = buff;
    }
}