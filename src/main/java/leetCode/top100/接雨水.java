package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * @Author: YaYa
 * @Create: 2020-06-12 16:51
 */
public class 接雨水 {
    /**
     * 单调递减栈
     *
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//        if (height.length == 0) return 0;
//        LinkedList<Integer> stack = new LinkedList<>();
//        int result = 0;
//        for (int i = 0; i < height.length; i++) {
//            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
//                int h = stack.pop();
//                if (stack.peek() != null) {
//                    result = result + (Math.min(height[stack.peek()], height[i]) - height[h])*(i-stack.peek()-1);
//                }
//            }
//            stack.push(i);
//        }
//        return result;
//    }

    /**
     * 双指针法
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int result = 0;
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int left_max=0,right_max=0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left]>=left_max)
                    left_max=height[left];
                else
                    result+=left_max-height[left];
                left++;
            } else {
                if (height[right]>=right_max)
                    right_max=height[right];
                else
                    result+=right_max-height[right];
                right--;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int height[] = {1,0,1};
        System.out.println(trap(height));
    }
}
