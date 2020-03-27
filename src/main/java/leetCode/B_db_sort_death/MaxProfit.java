package leetCode.B_db_sort_death;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName MaxProfit
 * @Description: 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-24 14:06
 */
public class MaxProfit {
//    public int maxProfit(int[] prices) {
//        if (prices.length < 2) return 0;
//        int maxP = 0;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < min) min = prices[i];
//            maxP = Math.max(maxP, prices[i] - min);
//        }
//        return maxP;
//    }

    //动态规划
    public int maxProfit(int[] prices){
        int len=prices.length;
        if (len<2) return 0;
        int maxProfit=0,loss=-prices[0];
        for (int i = 1; i < len; i++) {
            maxProfit=Math.max(maxProfit, loss+prices[i]);
            loss=Math.max(loss, -prices[i]);
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int[] num = {1, 5, 3, 6};
        maxProfit(num);
    }
}
