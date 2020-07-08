package leetCode.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Program: LeetCode
 * @Description:
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * @Author: YaYa
 * @Create: 2020-07-08 16:51
 */
public class 最长连续序列 {
    //先排序，动态规划  不符合题目要求o(n)复杂度
//    public int longestConsecutive(int[] nums) {
//        if (nums.length==0) return 0;
//        if (nums.length==1) return 1;
//        int[] dp=new int[nums.length];
//        Arrays.sort(nums);
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            dp[i]=1;
//            if (i==0) continue;
//            if (nums[i]-nums[i-1]==0)
//                dp[i]=dp[i-1];
//            if (nums[i]-nums[i-1]==1){
//                dp[i]=dp[i-1]+1;
//            }
//            if (dp[i]>max)
//                max=dp[i];
//        }
//        return max;
//    }

    public int longestConsecutive(int[] nums){
        Set<Integer> set=new HashSet<Integer>();
        for (int i:nums){
            set.add(i);
        }
        int max=Integer.MIN_VALUE;
        for (int i : nums) {
            int curr=0,len=1;
            if (set.contains(i)){
                curr=i;
            }
            while (set.contains(curr+1)){
                len+=1;
                curr++;
            }
            max=Math.max(len,max);
        }
        return nums.length==0?0:max;
    }
}
