package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。     进阶：  你能在线性时间复杂度内解决此题吗
 * @Author: YaYa
 * @Create: 2020-08-05 11:01
 */
public class 滑动窗口最大值 {
    /**
     * @param nums
     * @param k
     * @return 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7      3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length * k == 0) return new int[0];
        if (k == 1) return nums;
        //暴力法
//        int[] result=new int[nums.length-k+1];
//        for (int i = 0; i < nums.length-k+1; i++) {
//            int max=Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                if (nums[j]>max){
//                    max=nums[j];
//                }
//            }
//            result[i]=max;
//        }
//        return result;

        //动态规划

        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = nums[0];
        right[length - 1] = nums[length - 1];
        int[] res = new int[length - k + 1];
        for (int i = 1; i < length; i++) {
            left[i] = (i % k == 0) ? nums[i] : Math.max(left[i - 1], nums[i]);
            int j = length - 1 - i;
            right[j] = ((j + 1) % k == 0) ? nums[j] : Math.max(right[j + 1], nums[j]);
        }
        for (int i = 0; i < length - k + 1; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }
}
