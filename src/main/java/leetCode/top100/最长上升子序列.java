package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * @Author: YaYa
 * @Create: 2020-08-06 13:23
 */
public class 最长上升子序列 {
    //动态规划
//    public int lengthOfLIS(int[] nums) {
//        int len = nums.length;
//        if (len == 0 || len == 1) return len;
//        int[] dp = new int[len];
//        dp[0] = 1;
//        int max=1;
//        for (int i = 1; i < len; i++) {
//            int maxTemp = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j])
//                    maxTemp = Math.max(maxTemp, dp[j]);
//            }
//            dp[i] = maxTemp + 1;
//            max=Math.max(max, dp[i]);
//        }
//        return max;
//    }

    //动态规划+贪心+二分查找
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return len;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                int l = 0, r = end;
                while (l < r) {
                    final int mid = l + ((r - l) >>> 1);
                    if (tail[mid] >= nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                    System.out.println("循环");
                }
                tail[l] = nums[i];
            }
        }
        end++;
        return end + 1;
    }
}
