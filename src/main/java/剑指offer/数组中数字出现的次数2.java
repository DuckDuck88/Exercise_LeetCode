package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字。
 * @Author: YaYa
 * @Create: 2020-09-10 10:49
 */
public class 数组中数字出现的次数2 {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                bit[i] += num & 1;
                num = num >>> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | bit[31 - i] % 3;
        }
        return res;
    }
}
