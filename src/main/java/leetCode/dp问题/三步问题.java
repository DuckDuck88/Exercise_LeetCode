package leetCode.dp问题;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007
 * @Author: YaYa
 * @Create: 2020-08-17 10:24
 */
public class 三步问题 {
    //递归
//    public int waysToStep(int n) {
//        int result=0;
//        if (n==1) return 1;
//        if (n==2) return 2;
//        if (n==3) return 4;
//        return (waysToStep(n-1)+waysToStep(n-2)+waysToStep(n-3))%1000000007;
//    }

    //dp  dp[i]表示i阶台阶有多少种解法
    public int waysToStep(int n) {
        if (n < 3) return n;
        int[] dp = new int[4];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[3] = dp[2];
            dp[2] = dp[1];
            dp[1] = dp[0];
            dp[0] = ((dp[0] + dp[1]) % 1000000007 + dp[2]) % 1000000007;
        }
        return dp[0];
    }

    @Test
    public void test() {
        System.out.println(waysToStep(4));
    }
}
