package leetCode.top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description: 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
 * @Author: YaYa
 * @Create: 2020-08-25 09:50
 */
public class 和为K的子数组 {
//    public int subarraySum(int[] nums, int k) {
//        int result=0;
//        for (int start = 0; start < nums.length; start++) {
//            int num=0;
//            for (int end = start; end < nums.length; end++) {
//                num+=nums[end];
//                if (num==k) result++;
//            }
//        }
//        return result;
//    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(pre, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                result += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return result;
    }

    @Test
    public void test() {
        subarraySum(new int[]{1, 1, 1, 2, 3, 1, 5, 2, 1, 3, 1, 2, 1, 5, 1, 2, 1, 3, 8, 1, 2, 1, 4, 2, 1, 5, 21, 3, 5}, 8);
    }
}
