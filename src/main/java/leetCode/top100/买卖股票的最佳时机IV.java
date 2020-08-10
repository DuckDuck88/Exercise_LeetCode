package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票
 * @Author: YaYa
 * @Create: 2020-08-10 10:42
 */
public class 买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k * len == 0) return 0;
        int result = 0;
        if (k < (prices.length / 2)) {
            //dp[k][2] 表示第k次交易后的最大利润
            int[][] dp = new int[k][2];
            for (int i = 0; i < k; i++) {
                dp[i][0] = Integer.MIN_VALUE;
            }
            for (int p : prices) {
                dp[0][0] = Math.max(dp[0][0], 0 - p);
                dp[0][1] = Math.max(dp[0][1], dp[0][0] + p);
                for (int i = 1; i < k; i++) {
                    dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - p);
                    dp[i][1] = Math.max(dp[i][1], dp[i][0] + p);
                }
            }
            return dp[k - 1][1];
        } else {
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1])
                    result += prices[i] - prices[i - 1];
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[] test = {1, 2, 4};
        System.out.println(maxProfit(2, test));
    }
}
