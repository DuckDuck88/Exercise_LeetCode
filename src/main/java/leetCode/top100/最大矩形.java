package leetCode.top100;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Program: LeetCode
 * @Description: 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积
 * @Author: YaYa
 * @Create: 2020-06-28 16:51
 */
public class 最大矩形 {
//    /**
//     * 动态规划，本质暴力法，空间换时间
//     *
//     * @param matrix
//     * @return
//     */
//    public int maximalRectangle(char[][] matrix) {
//        if (matrix.length == 0 || matrix == null) return 0;
//        int result = 0;
//        int[][] dp = new int[matrix.length][matrix[0].length];
////                {'1', '0', '1', '0', '0'},
////                {'1', '0', '1', '1', '1'},
////                {'1', '1', '1', '1', '1'},
////                {'1', '0', '0', '1', '0'}};
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == '1')
//                    dp[i][j] = j>0?dp[i][j - 1] + 1:1;
//                int width = Integer.MAX_VALUE;
//                for (int k = i; k >= 0; k--) {
//                    if (matrix[k][j]=='0')
//                        break;
//                    width = Math.min(width, dp[k][j]);
//                    result = Math.max(result, width * (i - k + 1));
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 使用栈
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
        if (matrix.length==0||matrix==null) return 0;
        int result=0;
        int[] height=new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //一边循环一边求最大面积，节约空间
                height[j]=matrix[i][j]=='1'?height[j]+1:0;
            }
            result = Math.max(result,getResult(height));
        }
        return result;
    }

    private int getResult(int[] height) {
        int result = 0;
        //利用单调递增栈求最大面积
        LinkedList<Integer> stack=new LinkedList<>();
        int temHeight[]=new int[height.length+2];
        System.arraycopy(height, 0, temHeight, 1, height.length);
        //stack.push(-1);
        for (int j = 0; j < temHeight.length; j++) {
            while (!stack.isEmpty()&&stack.peek()!=-1&&temHeight[stack.peek()]>temHeight[j]){
                int h=temHeight[stack.pop()];
                result=Math.max(result, h*(j-stack.peek()-1));
            }
            stack.push(j);
        }
        return result;
    }

    @Test
    public void test() {
        char[][] ma =
                {{'1', '0', '1', '0', '0'},
                 {'1', '0', '1', '1', '1'},
                 {'1', '1', '1', '1', '1'},
                 {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(ma));
    }
}
