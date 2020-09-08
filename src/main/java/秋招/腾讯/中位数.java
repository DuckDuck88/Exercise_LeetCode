package 秋招.腾讯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description:
 * @Author: YaYa
 * @Create: 2020-09-06 21:39
 */
public class 中位数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int small = nums[n / 2 - 1];
        int max = nums[n / 2];
        for (int i = 0; i < n; i++) {
            if (i < n / 2)
                System.out.println(max);
            if (i >= n / 2)
                System.out.println(small);
        }
    }
    //1 3 4 5 6 7 8 9
}
