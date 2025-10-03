import java.util.Arrays;

public class Knapsack {
    static int h[] = {1,4,8,11};
    static int w[] = {3,3,4,5};
    static int capacity = 8;

    static int [][]dp = new int[1000][1000];
    public static void main(String[] args) {
        for (int i = 0; i< 1000;i++) {
            Arrays.fill(dp[i], -1);
        }
        int capacity = 7;
        System.out.println(calc(0, 8));
    }

    static int calc(int index, int capacity) {
        if (dp[index][capacity] != -1)return dp[index][capacity];
        if (index == h.length) {
            return 0;
        }
        if (w[index] > capacity) return calc(index + 1, capacity);
        dp[index][capacity] = Math.max(calc(index + 1, capacity), h[index] + calc(index, capacity - w[index]));
        return dp[index][capacity];
    }
}
