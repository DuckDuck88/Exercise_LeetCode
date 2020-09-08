package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *    你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * @Author: YaYa
 * @Create: 2020-09-07 13:10
 */
public class n个骰子的点数 {
    public double[] twoSum(int n) {
        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double tmp[] = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += pre[j] / 6;
                }
            }
            pre = tmp;
        }
        return pre;
    }
}
