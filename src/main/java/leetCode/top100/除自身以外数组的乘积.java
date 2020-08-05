package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
 * @Author: YaYa
 * @Create: 2020-08-04 10:13
 */
public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] outputs = new int[length];
        int[] l = new int[length];
        int[] r = new int[length];
        l[0] = 1;
        r[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
            r[length - i - 1] = r[length - i] * nums[length - i];
        }
        for (int i = 1; i < length - 1; i++) {
            outputs[i] = l[i] * r[i];
        }
        outputs[0] = r[0];
        outputs[length - 1] = l[length - 1];
        return outputs;
    }


}
