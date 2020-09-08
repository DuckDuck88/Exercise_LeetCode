package 秋招.米哈游;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description:
 * @Author: YaYa
 * @Create: 2020-08-21 20:51
 */
public class 两个分数的四则运算 {
    public static void main(String[] args) {
        两个分数的四则运算 obj = new 两个分数的四则运算();
        Scanner in = new Scanner(System.in);
        int[] num = new int[4];
        char[] sym = {'+', '-', '*', '/'};
        String s = in.nextLine();
        num[0] = s.charAt(0) - '0';
        num[1] = s.charAt(2) - '0';
        num[2] = s.charAt(6) - '0';
        num[3] = s.charAt(8) - '0';
        char r = s.charAt(4);
        if (r == '+' || r == '-') {
            System.out.println(obj.ad(num, r));
        } else if (r == '*') {
            System.out.println(obj.mut(num));
        } else {
            int temp = num[2];
            num[2] = num[3];
            num[3] = temp;
            System.out.println(obj.mut(num));
        }
    }

    //乘法
    private String mut(int[] num) {
        int[] result = new int[2];
        result[0] = num[0] * num[2];
        result[1] = num[1] * num[3];
        result = helper(result);
        return "" + result[0] + "/" + result[1];
    }

    //加法减法
    public String ad(int[] num, char r) {
        int[] result = new int[2];
        result[1] = num[1] * num[3];
        result[0] = r == '+' ? (num[0] * num[3] + num[2] * num[1]) : (num[0] * num[3] - num[2] * num[1]);
        result = helper(result);
        return result[0] + "/" + result[1];
    }

    //化简最简分数
    public int[] helper(int[] num) {
        for (int i = 2; i <= (num[0] > num[1] ? num[1] : num[0]); i++) {
            if (num[0] % i == 0 && num[1] % i == 0) {
                num[0] %= i;
                num[1] %= i;
                i = 2;
            }
        }
        return num;
    }
}
