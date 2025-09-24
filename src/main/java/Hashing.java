import kotlin.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hashing {

    static int dp[] = new int[21];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Arrays.fill(dp, -1);
        System.out.println(countMin(18));

        for (int i = 0; i<18; i++) {
            System.out.println(dp[i]);
        }

    }

    static int countMin(int n) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        for (int i = 1; i * i <= n; i++) {
            int x = i * i;
            min = Math.min(min, 1 + countMin(n - x));
        }
        dp[n] = min;
        return min;
    }
}
