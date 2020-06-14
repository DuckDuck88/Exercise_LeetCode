package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个 n × n 的二维矩阵表示一个图像。  将图像顺时针旋转 90 度。
 * 说明：  你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像
 * @Author: YaYa
 * @Create: 2020-06-13 15:20
 */
public class 旋转图像 {
    /**
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int line = matrix.length, row = line;
        //转置矩阵
        for (int i = 0; i < row; i++) {
            for (int j = i; j < line; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //反转每行
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][line-1-j];
                matrix[i][line-1-j]=temp;
            }
        }
    }

    @Test
    public void test() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(mat);
        System.out.println(mat.toString());
    }
}