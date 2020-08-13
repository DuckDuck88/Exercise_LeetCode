package leetCode.笔试练习;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description: 输入一个"YYYY-MM-dd"格式的日期字符串，输出该天是当年的第几天（1 月 1 日是每年的第 1 天）
 * @Author: YaYa
 * @Create: 2020-08-13 10:55
 */
public class 一年中的第几天 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] temp = s.split("-");
        int[] time = new int[3];
        for (int i = 0; i < 3; i++) {
            time[i] = Integer.parseInt(temp[i]);
        }
        int[] mon = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for (int i = 0; i < time[1]; i++) {
            res += mon[i];
        }
        if ((time[0] % 400 == 0 || (time[0] % 100 != 0 && time[0] % 4 == 0)) && time[1] > 2)
            System.out.println(res + time[2] + 1);
        else
            System.out.println(res + time[2]);
    }
}
