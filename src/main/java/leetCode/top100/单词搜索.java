package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用
 * @Author: YaYa
 * @Create: 2020-06-23 15:05
 */
public class 单词搜索 {
    /**
     * dfs 搜索过的位置置为“*”
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int row = board.length, line = board[0].length;
        boolean[][] status = new boolean[board.length][board[0].length];
        final int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, direct, status, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int[][] direct, boolean[][] status, int index, int x, int y) {
        if (index == word.length()-1) return board[x][y] == word.charAt(index);

        if (board[x][y] == word.charAt(index)) {
            status[x][y] = true;
            //四个方向  上下左右
            for (int i = 0; i < direct.length; i++) {
                int nx = x + direct[i][0];
                int ny = y + direct[i][1];
                if (scope(board, nx, ny)&& //范围
                        !status[nx][ny]&&  //状态
                        dfs(board, word, direct, status, index+1, nx, ny)) //递归
                    return true;
            }
            status[x][y] = false;
        }
        return false;
    }
    //判断新坐标是否符合条件
    private boolean scope(char[][] board, int x, int y) {
        return (x >= 0 &&
                x < board.length &&
                y >= 0 &&
                y < board[0].length);
    }

//    private boolean dfs(char[][] board, String word, int index, int i, int j) {
//        if (index == word.length()) return true;
//        if (board[i][j] == word.charAt(index)) {
//            // 上
//            if (i - 1 >= 0&&dfs(board, word, index + 1, i - 1, j)) return true;
//            // 下
//            if (i + 1 < board.length&&dfs(board, word, index + 1, i + 1, j)) return true;
//            // 左
//            if (j - 1 >= 0&&dfs(board, word, index, i, j - 1)) return true;
//            // 右
//            if (j + 1 < board[0].length&&dfs(board, word, index+1, i, j + 1)) return true;
//        }
//        return false;
//    }

    @Test
    public void test() {
        char[][] board = { {'a'},
                           {'s'},
                           {'a'}};
        System.out.println(exist(board, "a"));
    }

}
