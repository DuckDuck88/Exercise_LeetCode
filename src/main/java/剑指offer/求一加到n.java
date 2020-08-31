package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Author: YaYa
 * @Create: 2020-08-31 10:25
 */
public class 求一加到n {
    public int sumNums(int n) {
        int x = n;
        boolean flag = n > 0 && (x += sumNums(n - 1)) > 0;
        return x;
    }
}
