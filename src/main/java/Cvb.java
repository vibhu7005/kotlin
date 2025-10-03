import java.util.Arrays;

public class Cvb {
    static int c[] = {1,3,5};
    static int capacity = 5;
    static int ways = 0;
    static int[] dp = new int[1000];

    public static void main(String[] args) {
        int capacity = 7;
        Arrays.fill(dp, -1);

        System.out.println( calc(5));
    }

    static int calc(int count) {
        if(dp[count] != -1) return dp[count];
        if (count == 0) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]<=count) {
                return 1 + calc(count - c[i]);
            }
        }

        return 1;
    }
}


