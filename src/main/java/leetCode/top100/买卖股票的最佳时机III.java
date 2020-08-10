package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * @Author: YaYa
 * @Create: 2020-08-10 09:35
 */
public class 买卖股票的最佳时机III {
    /**
     * 动态规划  dp[i][j]表示当前最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int[][] dp = new int[length][4];
        //dp[i][0] 表示第一次买入时的利润
        //dp[i][1] 表示第一次卖出的利润
        //dp[i][2] 表示第二次买入时的利润
        //dp[i][3] 表示第二次卖出的利润
        //dp[i][5] 表示 未进行交易
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return Math.max(dp[length - 1][3], dp[length - 1][1]);
    }

    @Test
    public void test() {
        int pri[] = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(pri));
    }
}
