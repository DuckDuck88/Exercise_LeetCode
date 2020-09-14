package leetCode.dp问题;

/**
 * @Program: LeetCode
 * @Description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @Author: YaYa
 * @Create: 2020-09-11 14:43
 */
public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        //最大最小的状态变化考虑dp，每一步可能有两种情况向下或者向右，那么每一格可能是从上边或者左边过来
        //每一步都走最小，则结果最小。
        int row = grid.length;
        if (row == 0) return 0;
        int line = grid[0].length;
        int[][] res = new int[row][line];
        res[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (i == 0 && j != 0)
                    res[i][j] = res[i][j - 1] + grid[i][j];
                else if (i != 0 && j == 0)
                    res[i][j] = res[i - 1][j] + grid[i][j];
                else
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[row - 1][line - 1];
    }
}
