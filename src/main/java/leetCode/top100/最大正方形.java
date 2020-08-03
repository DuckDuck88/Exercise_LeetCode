package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，
 * 请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * @Author: YaYa
 * @Create: 2020-08-03 14:57
 */
public class 最大正方形 {
    /**
     * 动态规划，dp[i][j]为正方形的右下角,表示这个正方形的边长. dp[i][j]的值为dp[i-1][j],dp[i][j-1]和dp[i-1][j-1]中的最小值.
     * [["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]]
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, line = matrix[0].length;
        int result = matrix[0][0] - '0';
        int[][] dp = new int[row][line];
//        for (int i = 0; i < row; i++) {
//            dp[i][0] = matrix[i][0]-'0';
//        }
//        for (int i = 0; i < line; i++) {
//            dp[0][i] = matrix[0][i]-'0';
//        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                result = dp[i][j] > result ? dp[i][j] : result;
            }
        }
        return result * result;
    }
}
