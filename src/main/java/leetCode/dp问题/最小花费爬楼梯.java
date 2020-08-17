package leetCode.dp问题;

/**
 * @Program: LeetCode
 * @Description: 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯
 * @Author: YaYa
 * @Create: 2020-08-17 11:27
 */
public class 最小花费爬楼梯 {
    //dp
//    public int minCostClimbingStairs(int[] cost) {
//        int len = cost.length;
//        int[] dp = new int[len];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for (int i = 2; i < len; i++) {
//            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
//        }
//        return Math.min(dp[len -1],dp[len -2]);
//    }

    //空间优化
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int a, b, c;
        a = cost[0];
        b = cost[1];
        for (int i = 2; i < len; i++) {
            c = b;
            b = Math.min(a, b) + cost[i];
            a = c;
        }
        return Math.min(a, b);
    }

}