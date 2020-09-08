package 秋招.B站;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Program: LeetCode
 * @Description: 给出4个1-10的数字，通过加减乘除，得到数字24就算胜利
 * 你有 4 张写有 1 到 10 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * @Author: YaYa
 * @Create: 2020-08-13 19:24
 */
public class 算24点 {

    //回溯算法
    public boolean Game24Points(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return backTracking(list);
    }

    private boolean backTracking(List<Double> list) {
        if (list.size() == 0)
            return false;
        if (list.size() == 1)
            return Math.abs(list.get(0) - 24) < 1e-6;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> temp = new ArrayList<>();
                    for (Double dou : list) {
                        if (dou != list.get(i) && dou != list.get(j))
                            temp.add(dou);
                    }
                    Set<Double> set = calculate(list.get(i), list.get(j));
                    for (Double s : set) {
                        temp.add(s);
                        if (backTracking(temp))
                            return true;
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }

        return false;
    }

    private Set<Double> calculate(double i, double j) {
        Set<Double> set = new HashSet<>();
        set.add(i * j);
        set.add(i + j);
        set.add(i - j);
        set.add(j - i);
        if (i != 0)
            set.add(i / j);
        if (j != 0)
            set.add(j / i);

        return set;
    }


}
