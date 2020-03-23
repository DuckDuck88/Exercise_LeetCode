package leetCode.B_db_sort_death;

/**
 * @Program: LeetCode
 * @ClassName MaxSubArray
 * @Description: 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-23 22:10
 */
public class MaxSubArray {
    //动态规划
    public int maxSubArray(int[] nums) {
        int[] dp=nums;
        int result=dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i]+=Math.max(dp[i-1],0);
            result=Math.max(result, dp[i]);
        }
        return result;
    }
}
