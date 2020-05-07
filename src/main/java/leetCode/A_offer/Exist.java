package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName Exist
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-27 14:22
 */
public class Exist {
    //深度优先+剪枝
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        int row = board.length;       //行
        int line = board[0].length;   //列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (helper(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index >= word.length()
                || i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                ||word.charAt(index)!=board[i][j])
            return false;
        if (index == word.length() - 1)
            return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean result = false;
        result = helper(board, word, i - 1, j, index + 1)
                || helper(board, word, i + 1, j, index + 1)
                || helper(board, word, i, j - 1, index + 1)
                || helper(board, word, i, j + 1, index+1);
        board[i][j]=temp;
        return result;
    }
}
