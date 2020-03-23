package leetCode.writtenexamination;

import java.util.Arrays;

/**
 * @Program: LeetCode
 * @ClassName test1
 * @Description:
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-19 19:34
 */
public class test1 {
    static int len;
    static int[] h_i;
    public static void main(String[] args) {
        helper(len,h_i);
    }
    public static  int helper(int len, int[] h_i) {
        if (len != h_i.length)
            return 0;
        int max = 0;
        Arrays.sort(h_i);
        int left = 0;
        int right;
        if (len % 2 == 0) {
            right = (len - 1) / 2;
        } else {
            right = len / 2 - 1;
        }
        int index=right;
        for (; left < right; left++, right--) {
            h_i[left] = h_i[left] ^ h_i[right];
            h_i[right] = h_i[right] ^ h_i[left];
            h_i[left] = h_i[left] ^ h_i[right];
        }
        max=(h_i[len-1]-h_i[0])>(h_i[index+1]-h_i[index])?(h_i[len-1]-h_i[0]):(h_i[index+1]-h_i[index]);
        return max;
    }
}
