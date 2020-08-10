package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；
 * 非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * @Author: YaYa
 * @Create: 2020-08-10 13:33
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;
//        //dp[i][0] 表示第i天买入的最大利润，dp[i][1]表示第i天卖出的最大利润
//        int[][] dp=new int[len][2];
//        dp[0][0]=-prices[0]-fee;dp[0][1]=0;
//        for (int i = 1; i < len; i++) {
//            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]-fee);
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
//        }
//        return dp[len-1][1];
        int cash = 0, hold = -prices[0] - fee;
        for (int p : prices) {
            hold = Math.max(hold, cash - p - fee);
            cash = Math.max(cash, hold + p);
        }
        return cash;
    }
}
