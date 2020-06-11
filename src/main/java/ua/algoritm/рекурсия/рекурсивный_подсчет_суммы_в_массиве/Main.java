package ua.algoritm.рекурсия.рекурсивный_подсчет_суммы_в_массиве;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int [] arr = {12,3,2,1,4};
//        System.out.println(sum(arr));
    }

    static int sum( int arr [] ){
        if(arr.length == 1) return arr[0];
        return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
    }
}
