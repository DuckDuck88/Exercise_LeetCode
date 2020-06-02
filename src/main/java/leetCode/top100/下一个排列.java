package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * @Author: YaYa
 * @Create: 2020-05-11 12:36
 */
public class 下一个排列 {
    /**
    * @description: 从右侧开始i=0，找第一个 nums[i-1]>nums[i]。然后反向寻找最小的大于nums[i]的位置，交换。反转
     *  eg：7845 79865；=》7845 89765=》9845 98765=》9845 98567
    * @params: [nums]
    * @return: void
    * @Author: Mr.Liu
    * @Date: 2020/5/30
    */
    public void nextPermutation(int[] nums) {
        if (nums.length==1) System.out.println(nums);
        int index=0; //标志位，标识从哪里开始反
        for (int i = nums.length-1; i > 0 ; i--) {
            //寻找特殊位置
            if (nums[i]>nums[i-1]){
                index=i;
                int j=nums.length-1;
                while (nums[j]<=nums[i-1]){
                    j--;
                }
                swap(nums, i-1, j);
                break;
            }
        }
        //反转[index,nums.length-1]
        reverse(nums, index, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //交换
    private void swap(int nums[],int i,int j){
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }

    //原地反转数组
    private void reverse(int[] nums,int left,int right){
        int l=left,r=right;
        while (l<r){
            swap(nums, l++, r--);
        }
    }

    @Test
    public void testDemo(){
        int[] nums={};
        nextPermutation(nums);
    }
}
