package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName 剪绳子
 * @Description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-27 16:08
 */
public class 剪绳子 {
    //数学归纳法
//    public int cuttingRope(int n) {
//        if (n == 2) return 1;
//        if (n == 3) return 2;
//        int a = n / 3;
//        int b = n % 3;
//        if (b == 1)
//            return (int) (Math.pow(3, a - 1) * 4);
//        else if (b == 2)
//            return (int) (Math.pow(3, a) * 2);
//        else
//            return (int) Math.pow(3, a);
//    }
    //动态规划法
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }
}
