package 秋招.小米;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格,同一个单元格内的字母不允许被重复使用。
 * @Author: YaYa
 * @Create: 2020-09-08 18:44
 */
public class 单词搜索 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() == 0) {
            System.out.println("true");
            return;
        }
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(dfs(board, s));
    }

    public static String dfs(char[][] board, String s) {
        int row = board.length;
        if (row == 0) return "false";
        int line = board[0].length;
        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (board[i][j] != chars[0])
                    continue;
                //匹配到第一个字符相等
                if (mymatch(board, i, j, chars, 0)) {
                    return "true";
                }
            }
        }
        return "false";
    }

    public static boolean mymatch(char[][] board, int x, int y, char[] chars, int i) {
        if (board[x][y] != chars[i]) return false;
        board[x][y] = '#';
        i++;
        if (i == chars.length) return true;
        if (x - 1 >= 0 && mymatch(board, x - 1, y, chars, i)) return true;
        if (x + 1 < board.length && mymatch(board, x + 1, y, chars, i)) return true;
        if (y - 1 >= 0 && mymatch(board, x, y - 1, chars, i)) return true;
        if (y + 1 < board.length && mymatch(board, x, y + 1, chars, i)) return true;
        board[x][y] = chars[i - 1];
        return false;
    }

}
