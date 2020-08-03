package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，
 * 请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * @Author: YaYa
 * @Create: 2020-08-03 15:30
 * [[1,0,1],
 * [1,1,0],
 * [1,1,0]]
 */
public class 统计全为一的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        int result = 0;
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return result;
        int row = matrix.length, line = matrix[0].length;
        int dp[][] = new int[row][line];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = matrix[i][j] == 1 ? Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1 : 0;
                }
                result += dp[i][j];
            }
        }
        return result;
    }
}
