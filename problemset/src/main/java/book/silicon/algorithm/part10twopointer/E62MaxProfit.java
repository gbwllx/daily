package book.silicon.algorithm.part10twopointer;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/27.
 */
public class E62MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {return 0;}
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
