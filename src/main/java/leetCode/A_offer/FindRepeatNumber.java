package leetCode.A_offer;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName FindRepeatNumber
 * @Description: 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 22:20
 */
public class FindRepeatNumber {
    //方法一：哈希集合
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set=new HashSet<>();
//        for (int i:nums){
//            if (set.contains(i))
//                return i;
//            set.add(i);
//        }
//        return -1;
//    }

    //因为数组的长度和数组的内容恰好可以一一对应。所以可以把数组本身看作哈希表
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        for (; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }

        }
        return -1;
    }

    @Test
    public  void testDemo(){
        int nums[]={1,2,3,1};
        System.out.println(findRepeatNumber(nums));
    }
}
