package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)
 * @Author: YaYa
 * @Create: 2020-09-10 12:05
 */
public class 数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        int mask = 1;
        while ((mask & res) == 0) {
            mask <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[]{a, b};
    }
}
