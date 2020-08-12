package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数
 * @Author: YaYa
 * @Create: 2020-08-12 14:26
 */
public class 目标和 {
    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        //backtracking(nums, 0, S);
        //backtracking(nums, 0, 0, S);
        return result;
    }

//    public void backtracking(int[] nums, int index, int sum,int S) {
//        if (index==nums.length){
//            if (sum==S)
//                result++;
//            return;
//        }
//        backtracking(nums, index+1, sum+nums[index],S);
//        backtracking(nums, index+1, sum-nums[index],S);
//    }

//    public void backtracking(int[] nums, int index, int S) {
//        if (index == nums.length) {
//            if (S == 0)
//                result++;
//            return;
//        }
//        S = S - nums[index];
//        backtracking(nums, index + 1, S);
//        S = S + nums[index];
//        S = S + nums[index];
//        backtracking(nums, index + 1, S);
//        S = S - nums[index];
//    }
}
