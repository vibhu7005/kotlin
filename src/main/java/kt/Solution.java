package kt;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int stockPrices[] = new int[]{7, 2, 10, 14, 18, 8, 6, 1, 22};
        int maxPriceAfter[] = new int[stockPrices.length];
        int maxValue = 0;
        for (int i = stockPrices.length - 1; i >= 0; i--) {
            maxPriceAfter[i] = maxValue;
            if (stockPrices[i] > maxValue) {
                maxValue = stockPrices[i];
            }
        }

        int maxProfit = 0;
        for (int i = 0; i < stockPrices.length; i++) {
            int value = maxPriceAfter[i] - stockPrices[i];
            if (value > maxProfit) {
                maxProfit = value;
            }
        }
        System.out.println(maxProfit);
    }
}
