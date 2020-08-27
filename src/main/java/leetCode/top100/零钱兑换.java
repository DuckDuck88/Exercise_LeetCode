package leetCode.top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Program: LeetCode
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1
 * @Author: YaYa
 * @Create: 2020-08-25 10:52
 */
public class 零钱兑换 {
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount == 0) return 0;
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void helper(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0)
            return;

        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            helper(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{1, 2, 3, 4}, 6));
    }
}
