package leetCode.top100;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Program: LeetCode
 * @Description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1
 * @Author: YaYa
 * @Create: 2020-06-23 18:48
 */
public class 柱状图中最大的矩形 {
    /**
     * 单调递增栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int[] heights2=new int[heights.length+2];
        System.arraycopy(heights, 0, heights2, 1, heights.length);
        for (int i = 0; i < heights2.length; i++) {
            while (!stack.isEmpty() && heights2[i] < heights2[stack.peek()]) {
                int h = heights2[stack.pop()];
                max = Math.max(max, h * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max==Integer.MIN_VALUE?0:max;
    }

    @Test
    public void test() {
        int[] heihts = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heihts));
    }
}
