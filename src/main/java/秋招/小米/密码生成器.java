package 秋招.小米;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description: 注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。
 * 检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。
 * 符合要求，返回 0；长度不符合返回 1；类型不符合要求返还 2。
 * 可以一次输入多组密码，以空格符间隔，空格符不作为密码。
 * @Author: YaYa
 * @Create: 2020-09-08 18:14
 */
public class 密码生成器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split("\\s+");
        for (int i = 0; i < strings.length; i++) {
            boolean[] flag = {false, false, false, false};//数字 大写 小写 符号
            if (strings[i].length() < 8 || strings[i].length() > 120) {
                System.out.println("1");
                continue;
            }
            for (int j = 0; j < strings[i].length(); j++) {
                char c = strings[i].charAt(j);
                if (c >= '0' && c <= '9')
                    flag[0] = true;
                else if (c >= 'A' && c <= 'Z')
                    flag[1] = true;
                else if (c >= 'a' && c <= 'z')
                    flag[2] = true;
                else
                    flag[3] = true;
                if (flag[0] && flag[1] && flag[2] && flag[3])
                    break;
            }
            if (flag[0] && flag[1] && flag[2] && flag[3])
                System.out.println("0");
            else
                System.out.println("2");
        }
    }

}
