package leetCode.A_offer;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName Fib
 * @Description: ，求斐波那契（Fibonacci）数列的第 n 项
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-05 23:01
 */
public class Fib {
    public int fib(int n) {
        if (n == 0)  return 0;
        if (n == 1)  return 1;
        int [] nums=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        int pre=1;
        int prepre=0;
        int result=0;
        for (int i = 2; i < n + 1; i++) {
            //nums[i]=(nums[i-1]+nums[i-2])%1000000007;
            result=pre+prepre;
            prepre=pre;
            pre=result;
            System.out.println(result);
        }
        return result;
    }

    @Test
    public  void testDemo(){
        fib(30);
    }
}
