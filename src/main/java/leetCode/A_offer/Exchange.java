package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName Exchange
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-06 18:40
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            while (left<right&&(nums[left]&1)!=0) left++;
            while (left<right&&(nums[right]&1)!=1) right--;
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        return nums;
    }
}
