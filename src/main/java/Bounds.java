import kt.academy.learnprogramming.challenge2.Array;

import java.util.Arrays;

public class Bounds {

    public static void main(String[] args) {
        int[] array = {1,1,1,1,2,2,2,3};
        System.out.println(upperBound(array, 1));
    }

    static int upperBound(int[] a, int m) {
        return findUpperBound(a, m, 0, a.length-1);
    }

    static int findUpperBound(int[] a, int m, int start, int end) {
        if (start > end) {
            return end;
        }
        int index = start + (end-start)/2;
        if (a[index] <= m) {
            return findUpperBound(a, m, index + 1, end);
        } else {
            return findUpperBound(a, m , start, index - 1);
        }
    }
}
