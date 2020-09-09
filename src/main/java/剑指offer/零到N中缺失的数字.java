package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * @Author: YaYa
 * @Create: 2020-09-09 11:06
 */
public class 零到N中缺失的数字 {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }
}
