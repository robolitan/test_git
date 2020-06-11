package ua.algoritm.рекурсия;

public class MainRecursion {
    public static void main(String[] args) {
        System.out.println(getFactorial(3,5));
    }

    private static int getFactorial(int i, int i1) {
        if(i == i1) return i1;
        return i++ * getFactorial(i, i1);
    }

}
