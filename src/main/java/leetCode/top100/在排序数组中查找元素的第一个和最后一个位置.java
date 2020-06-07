package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。  你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * @Author: YaYa
 * @Create: 2020-06-03 11:29
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * @description: 二分查找，找到之后向左右寻找
     * @param: [nums, target]
     * @return: int[]
     * @Author: YaYa
     * @Date: 2020/6/3
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) return new int[]{-1,-1};
        int index = binarySearch(nums, 0, nums.length-1, target);
        int left = index, right = index;
        while ((left - 1) >= 0 && nums[left - 1] == target) left--;
        while (right + 1 < nums.length && nums[right + 1] == target) right++;
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (left>right) return -1;
        if (left == right) return nums[mid]==target?left:-1;
        if (nums[mid] == target)
            return mid;
        else {
            return target > nums[mid] ? binarySearch(nums, mid + 1, right, target) : binarySearch(nums, left, mid - 1, target);
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,2,3};
        int target = 0;
        for (int i : searchRange(nums, target)) {
            System.out.println(i);
        }
    }
}
