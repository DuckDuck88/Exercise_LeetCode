package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * @Author: YaYa
 * @Create: 2020-07-12 15:34
 */
public class 乘积最大子数组 {
    /**
     * 动态规划，dp[i]=Math.max(1, dp[i-1])*nums[i];
     *
     * @param nums
     * @return
     */
//    public int maxProduct(int[] nums) {
//        if (nums.length==0) return 0;
//        int max=nums[0];
//        int[] dpMax=new int[nums.length];
//        int[] dpMin=new int[nums.length];
//        dpMax[0]=nums[0];
//        dpMin[0]=nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dpMax[i]=Math.max(Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
//            dpMin[i]=Math.min(Math.min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]), nums[i]);
//            if (dpMax[i]>max){
//                max=dpMax[i];
//            }
//        }
//        return max;
//    }
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max, min, result;
        max = min = result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i] * max, nums[i]);
            min = Math.min(nums[i] * min, nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
