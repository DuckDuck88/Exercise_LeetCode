package leetCode.笔试练习;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description: 输入两个表示复数的字符串，输出它们相乘的结果的字符串 复数字符串用a+bi表示(a, b 为整数, i为虚数单位，i2=1)
 * @Author: YaYa
 * @Create: 2020-08-13 10:24
 */
public class 复数乘法 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();
        String[] s1 = s3.split("\\+|i");
        String[] s2 = s4.split("\\+|i");
        int s11 = Integer.parseInt(s1[0]);
        int s21 = Integer.parseInt(s2[0]);
        int s12 = Integer.parseInt(s1[1]);
        int s22 = Integer.parseInt(s2[1]);
        //if (s3.charAt(s3.length() - 1) == 'i' && s4.charAt(s4.length() - 1) == 'i')
        System.out.println(s11 * s21 - s12 * s22 + "+" + (s11 * s22 + s21 * s12) + "i");
//        else if (s3.charAt(s3.length() - 1) != 'i'&& s4.charAt(s4.length() - 1) == 'i')
//            System.out.println((s11+s12)*s21+(s11));
    }
}
