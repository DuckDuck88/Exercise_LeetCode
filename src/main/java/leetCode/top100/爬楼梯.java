package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数
 * @Author: YaYa
 * @Create: 2020-06-18 16:20
 */
public class 爬楼梯 {
//    public int climbStairs(int n) {
//        if(n==1) return 1;
//        int dp[] =new int[n+1];
//        dp[1]=1;
//        dp[2]=2;
//        for (int i = 3; i < n+1; i++) {
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n];
//    }


    //动态规划优化
    public int climbStairs(int n) {
        if (n==1) return 1;
        int front=1,later=2;
        for (int i = 3; i < n + 1; i++) {
            front=front+later;
            int temp=front;
            front=later;
            later=temp;
        }
        return later;
    }
    @Test
    public void test(){
        System.out.println(climbStairs(3));
    }
}
