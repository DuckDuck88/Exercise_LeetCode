package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * @Author: YaYa
 * @Create: 2020-09-01 11:31
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int sum = 0;
        while (i < (target + 1) / 2) {
            if (sum == target) {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            } else if (sum < target) {
                sum += j;
                j++;
            } else {
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    @Test
    public void test() {
        findContinuousSequence(9);
    }
}
