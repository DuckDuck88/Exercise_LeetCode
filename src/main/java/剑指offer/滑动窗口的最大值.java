package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
 * @Author: YaYa
 * @Create: 2020-09-09 10:11
 */
public class 滑动窗口的最大值 {

    /**
     * 暴力法
     *
     * @param nums
     * @param k
     * @return
     */
//    List<Integer> res=new ArrayList<>();
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        if (len ==0) return new int[0];
//        // [left,right) 左闭右开
//        int left=0,right=left+k;
//        for (; right <= len; left++,right++) {
//            //判断每个窗口的最大值并将其加入结果数组
//            max(nums,left,right);
//        }
//        return res.stream().mapToInt(Integer::intValue).toArray();
//    }
//
//    private void max(int[] nums, int left, int right) {
//        int m=Integer.MIN_VALUE;
//        for (int i = left; i < right; i++) {
//            m=Math.max(nums[i],m);
//        }
//        res.add(m);
//    }

//    int index = -1;
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        if (len == 0) return new int[0];
//        // [left,right) 左闭右开
//        int left = 0, right = left + k;
//        int[] res = new int[nums.length - k + 1];
//        for (int i = 0; right <= len; i++, left++, right++) {
//            //判断每个窗口的最大值并将其加入结果数组
//            if (index >= left && index < right && nums[index] > nums[right - 1])
//                res[i] = nums[index];
//            else
//                res[i] = max(nums, left, right);
//        }
//        return res;
//    }
//
//    private int max(int[] nums, int left, int right) {
//        int m = Integer.MIN_VALUE;
//        for (int i = left; i < right; i++) {
//            if (nums[i]>m){
//                m=nums[i];
//                index=i;
//            }
//        }
//        return m;
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) return new int[0];
        int[] res = new int[len - k + 1];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = (i % k == 0) ? nums[i] : Math.max(nums[i], left[i - 1]);
            int j = len - i - 1;
            right[j] = ((j + 1) % k == 0) ? nums[j] : Math.max(nums[j], right[j + 1]);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }
}
