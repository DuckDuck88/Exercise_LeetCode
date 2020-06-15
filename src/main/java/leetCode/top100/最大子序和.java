package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * @Author: YaYa
 * @Create: 2020-06-14 15:58
 */
public class 最大子序和 {
    /**
     * fn=f(n-1)+ai>f(n-1)? f(n-1)+ai:ai
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        int max=Integer.MIN_VALUE;
//        if (nums.length==0) return max;
//        int[] dp=new int[nums.length];
//        dp[0]=nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i]=(dp[i-1]+nums[i])>nums[i]?(dp[i-1]+nums[i]):nums[i];
//        }
//        for (int i = 0; i < dp.length; i++) {
//            if (dp[i]>max) max=dp[i];
//        }
//        return max;
//    }

    //优化后
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        if (nums.length==0) return max;
        int pre=0;
        for (int i = 1; i < nums.length; i++) {
            pre=Math.max(nums[i]+pre,nums[i]);
            max=Math.max(max, pre);
        }
        return max;
    }
    @Test
    public void test(){
        int[] x={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(x));
    }
}
