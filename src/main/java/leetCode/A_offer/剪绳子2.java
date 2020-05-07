package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName 剪绳子2
 * @Description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-27 19:42
 */

/*
* 未解
* */
public class 剪绳子2 {
    public int cuttingRope(int n) {
        if (n==2) return 1;
        int a=n/3;
        int b=n%3;
        if (b==0)
            return (int) power(3, a);
        else if (b==1)
            return (int) (power(3, a-1)*4);
        return (int) (Math.pow(3, a)*2);
    }
    private int power(int a,int b){
        int result=1;
        while (b!=0){
            if ((b&1)!=0) result=(result*a)%1000000007;
            a=(a%1000000007*a%1000000007)%1000000007;
            b=b>>1;
        }
        return result;
    }


//    //方法二 动态规划
//    public int cuttingRope(int n){
//        int[] dp=new int[n+1];
//        dp[1]=dp[2]=1;
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < i; j++) {
//                dp[i]=Math.max(Math.max((j*(i-j))%1000000007, (j*dp[i-j])%1000000007), dp[i]);
//                Integer.MAX_VALUE
//            }
//        }
//        return dp[n];
//    }
}
