package 秋招.B站;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Program: LeetCode
 * @Description: 面值 1,4,16,64四种硬币，以及面值1024的纸币。
 * 使用1024的纸币购买价值为N的商品。请问最少收到多少硬币
 * @Author: YaYa
 * @Create: 2020-08-13 20:03
 */
public class 找零 {

    //贪心
//    public int GetCoinCount(int N) {
//        int coin=64;
//        int count=0;
//        N=1024-N;
//        while (N!=0){
//            count+=N/coin;
//            N%=coin;
//            coin>>=1;
//        }
//        return count;
//    }

    //背包问题
    public int GetCoinCount(int N) {
        int[] coin = {1, 2, 4, 16, 64};
        int[] dp = new int[1024 - N];
        Arrays.fill(dp, 1024);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < coin.length; j++) {
                if (i > coin[j])
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    @Test
    public void test() {
        System.out.println(GetCoinCount(250));
    }
}
