package ua.algoritm.мемоизация;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

class TEST_FOR_TEST {
    int x;
}

public class MainMemoization {
    public static void main(String[] args) throws InterruptedException {

    }
//        int SIZE = 100;
//
///*
//        long l = System.nanoTime();
//        System.out.println(fibonacci(SIZE));
//        long after = System.nanoTime();
//        System.out.println("spend - " + (double) (after - l) / 1000000 + " ms");*/
//
//        long mem[] = new long[SIZE + 1];
//        Arrays.fill(mem, -1);
//
//        long l = System.nanoTime();
//        System.out.println(fibonacciWithMemonization(SIZE, mem));
//        System.out.println(fibonacci(SIZE));
//        long after = System.nanoTime();
//
//        System.out.println("spend time with memoization- " + (double) (after - l) / 1000000 + " ms");


//     1  1  2  3  5  8  13  21  34 55 89
//     1  2  3  4  5  6  7   8   9  10 11 12

    static long fibonacci(int n) {
        if (n <= 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static long fibonacciWithMemonization(int n, long[] mem) {
        if (mem[n] != -1) return mem[n];
        if (n <= 1) return 1;
        long result = fibonacciWithMemonization(n - 1, mem) + fibonacciWithMemonization(n - 2, mem);
        mem[n] = result;
        return result;
    }
}
