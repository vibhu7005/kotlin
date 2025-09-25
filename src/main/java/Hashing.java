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
        int []arr = {1,2,3,4,0};
        int []maxProfit = new int[arr.length];
        Arrays.fill(maxProfit, -1);
        int ans = 0;
        maxProfit[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            maxProfit[i] = 0;
            maxProfit[i] = Math.max(maxProfit[i], maxProfit[i - 1]);

            for (int j = i-1; j >=0; j--) {
                if (j != 0) {
                    maxProfit[i] = Math.max(maxProfit[i], arr[i] - arr[j] + maxProfit[j - 1]);
                } else {
                    maxProfit[i] = Math.max(maxProfit[i], arr[i] - arr[j]);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(maxProfit[i] + " ");
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
