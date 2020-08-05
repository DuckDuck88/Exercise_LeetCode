package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序
 * @Author: YaYa
 * @Create: 2020-08-04 11:08
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
//        if (nums==null) return;
//        int curr=0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]!=0){
//                nums[curr++]=nums[i];
//            }
//        }
//        for (int i = curr; i < nums.length; i++) {
//            nums[i]=0;
//        }
        if (nums == null) return;
        int divide = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[divide];
                nums[divide++] = nums[i];
                nums[i] = temp;
            }
        }
    }


}
