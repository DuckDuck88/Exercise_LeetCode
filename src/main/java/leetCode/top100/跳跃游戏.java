package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * @Author: YaYa
 * @Create: 2020-06-14 16:33
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index >= nums.length - 1)
                return true;
            if (i <= index) {
                index = i + nums[i] > index ? i + nums[i] : index;
            }
        }
        return false;
    }


    @Test
    public void test() {
        int[] x = {2, 4, 4, 2,1,0,2};
        System.out.println(canJump(x));
    }
}
