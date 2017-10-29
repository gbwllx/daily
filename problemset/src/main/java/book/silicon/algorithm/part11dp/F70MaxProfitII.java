package book.silicon.algorithm.part11dp;

/**
 * description: 股票买卖
 * 给出一个数组，第i个元素代表第i天的股票，求最大交易利润。允许最多交易两次。
 * 一维数组currProfit记录截止当日最大利润
 * currProfit[i] = max(currProfit[i-1],prices[i]-low)
 * 一维数组futureProfit记录当日以后的交易最大利润
 * futureProfit[i] = max(futureProfit[i+1],high-prices[i])
 * 以最大利润通过从尾到头逆向扫描数组获得合计之前计算的利润，求出最大利润
 * maxProfit = max(maxProfit, currProfit[i]+futureProfit[i])
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F70MaxProfitII {
    int maxProfitII(int[] prices) {
        int len = prices.length;
        if (len == 0) { return 0; }
        int[] currProfit = new int[len];
        int[] futureProfit = new int[len];
        int low = prices[0];
        int maxProfit = 0;
        //记录截止当日最大利润
        for (int i = 1; i < len; ++i) {
            low = Math.min(low, prices[i]);
            currProfit[i] = Math.max(currProfit[i - 1], prices[i] - low);
        }
        int high = prices[len - 1];
        //计算该日以后的交易最大利润，合计之前计算的利润，求出最大利润
        for (int i = len - 1; i >= 0; --i) {
            high = Math.max(high, prices[i]);
            if (i < len - 1) {
                futureProfit[i] = Math.max(futureProfit[i + 1], high - prices[i]);
            }
            maxProfit = Math.max(maxProfit, currProfit[i] + futureProfit[i]);
        }
        return maxProfit;
    }
}
