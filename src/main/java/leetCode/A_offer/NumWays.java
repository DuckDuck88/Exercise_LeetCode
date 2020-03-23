package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName NumWays
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-06 16:17
 */
public class NumWays {
    //解题思路：因为青蛙可以跳1也可以跳2，所以最后一次跳时，还剩几个台阶取决于前面的台阶是怎么跳的。
    //典型的动态规划问题。自底向上，状态不断转移
    //状态转移方程如何得到,假设n个台阶有f（n）个解法
    //则最后一步有两种情况，剩n-1个或者n-2个
    // n-1个台阶有f（n-1），n-2个台阶有f（n-2）。
    //f（n）=f（n-1）+f（n-2）

    //记忆优化法
//    public int numWays(int n) {
//        if(n==0) return 1;
//        if(n==1) return 1;
//        int[] nums=new int[n+1];
//        nums[0]=1;
//        nums[1]=1;
//        nums[2]=2;
//        for (int i = 3; i < n+1; i++) {
//            nums[i]=(nums[i-1]+nums[i-2])%1000000007;
//        }
//        return nums[n];
//    }
    /**
    * @description:
    * @params:
    * @return:
    * @Author: Mr.Liu
    * @Date: 2020/3/6
    */
    public int numWays(int n) {
        int[] nums=new int[3];
        nums[0]=1;
        nums[1]=1;
        nums[2]=2;
        for (int i=3;i<n+1;i++){
            nums[i%3]=(nums[(i-1)%3]+nums[(i-2)%3])%1000000007;
        }
        return nums[n%3];
    }
}
