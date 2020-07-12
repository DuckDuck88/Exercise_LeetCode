package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 * @Author: YaYa
 * @Create: 2020-07-12 23:04
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (len == 0) return 0;
        if (len == 1) return nums[1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[len - 1];
    }
}
