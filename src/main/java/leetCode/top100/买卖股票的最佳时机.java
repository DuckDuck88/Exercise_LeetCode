package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票
 * @Author: YaYa
 * @Create: 2020-06-29 18:52
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int result=0;
        if (prices.length==0) return result;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i; j < prices.length; j++) {
//                result=Math.max(result, prices[j]-prices[i]);
//            }
//        }
        int min=prices[0];
        for (int i = 0; i < prices.length; i++) {
            min=Math.min(min, prices[i]);
            result= Math.max(result, prices[i]-min);
        }
        return result;
    }
}
