package leetCode.top100;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Program: LeetCode
 * @Description: 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。  你找到的子数组应是最短的，请输出它的长度
 * @Author: YaYa
 * @Create: 2020-08-11 10:13
 */
public class 最短无序连续子数组 {
    /**
     * 双指针解法
     */
//    public int findUnsortedSubarray(int[] nums) {
//        int len = nums.length;
//        if (len < 2) return 0;
//        int start = nums[len-1], end = nums[0];
//        for (int i = 1; i < len; i++) {
//            if (nums[i] < nums[i - 1]) {
//                start = Math.min(start, nums[i]);
//                end = Math.max(end, nums[i - 1]);
//            }
//        }
//        int i;
//        for (i = 0; i < len; i++) {
//            if (nums[i] > start) {
//                break;
//            }
//        }
//        int j;
//        for (j = len - 1; j >= 0; j--) {
//            if (nums[j] < end) {
//                break;
//            }
//        }
//        return j-i>0?j-i+1:0;
//    }

    /**
     * 单调栈解法
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int l = len - 1, r = 0;
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            int index = stack.peek();
            if (index == -1 || nums[i] >= nums[index])
                stack.push(i);
            else {
                while (!stack.isEmpty() && stack.peek() != -1 && nums[i] < nums[stack.peek()]) {
                    l = Math.min(l, stack.poll());
                }
            }
        }
        stack.clear();
        stack.push(len);
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = stack.peek();
            if (index == len || nums[i] <= nums[index])
                stack.push(i);
            else {
                while (!stack.isEmpty() && stack.peek() != len && nums[i] > nums[stack.peek()]) {
                    r = Math.max(r, stack.poll());
                }
            }
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    @Test
    public void test() {
        int[] te = {2, 1};
        System.out.println(findUnsortedSubarray(te));
    }
}
