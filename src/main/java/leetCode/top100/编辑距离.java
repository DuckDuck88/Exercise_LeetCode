package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：  插入一个字符 删除一个字符 替换一个字符
 * @Author: YaYa
 * @Create: 2020-06-18 16:46
 */
public class 编辑距离 {

    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) dp[i][0]=i;
        for (int i = 0; i <= n; i++) dp[0][i]=i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i)==word2.charAt(j))
                    dp[i][j]=dp[i-1][j-1];
                else {
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
