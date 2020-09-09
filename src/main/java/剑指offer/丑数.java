package 剑指offer;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @Author: YaYa
 * @Create: 2020-09-09 13:39
 */
public class 丑数 {

    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        int a = 0, b = 0, c = 0;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int ta = res[a] * 2, tb = res[b] * 3, tc = res[c] * 5;
            res[i] = Math.min(ta, Math.min(tb, tc));
            if (ta == res[i])
                a++;
            if (tb == res[i])
                b++;
            if (tc == res[i])
                c++;
        }
        return res[n - 1];
    }

    @Test
    public void test() {
        nthUglyNumber(10);
    }
}
