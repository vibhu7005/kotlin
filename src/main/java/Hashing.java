import kotlin.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hashing {

    static int lis[] = new int[11];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        lis[0] = 1;
        int arr[] = {0,8,4,12,2,10,16,1,9,5,13};
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i-1; j >=0; j--) {
                if (arr[j] < arr[i]) {
                    lis[i] = lis[j]+1;
                    break;
                }
            }
            if (j == -1) {
                lis[i] = 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(lis[i] + " ");
        }
    }

//    static int countMin(int n) {
//        if (n == 0) return 0;
//
//        if (dp[n] != -1) return dp[n];
//
//        for (int i = 1; i * i <= n; i++) {
//            int x = i * i;
//            min = Math.min(min, 1 + countMin(n - x));
//        }
//        dp[n] = min;
//        return min;
//    }
}
