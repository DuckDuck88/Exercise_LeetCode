package 剑指offer;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @Author: YaYa
 * @Create: 2020-09-01 10:23
 */
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        while (b != 0) {
            int cary = (a & b) << 1;
            a = a ^ b;
            b = cary;
        }
        return a;
    }

    @Test
    public void test() {
        add(4, 5);
    }

}
