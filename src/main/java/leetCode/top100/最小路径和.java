package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。  说明：每次只能向下或者向右移动一步
 * @Author: YaYa
 * @Create: 2020-06-17 16:12
 */
public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int line = grid[0].length;
        int[][] dp = new int[row][line];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if (i == 0 && j != 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (i != 0 && j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][line - 1];
    }
}
