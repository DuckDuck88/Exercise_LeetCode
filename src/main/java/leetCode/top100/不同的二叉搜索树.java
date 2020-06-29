package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种
 * @Author: YaYa
 * @Create: 2020-06-26 17:03
 */
public class 不同的二叉搜索树 {

    /**
     * 动态规划 G(n)=f(1)+...+f(n)  f(i)=G(i-1)*G(n-i)
     * G(n)=G(0)*G(n-0)+G(1)*G(n-1)+...+G(n)*G(n-n)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
