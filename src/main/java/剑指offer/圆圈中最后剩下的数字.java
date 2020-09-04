package 剑指offer;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 0, 1, , n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * @Author: YaYa
 * @Create: 2020-09-04 11:46
 */
public class 圆圈中最后剩下的数字 {

    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }


//    public int lastRemaining(int n, int m) {
//        List<Integer> list=new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(i);
//        }
//        int index=0;
//        for (int i = 0; i < n - 1; i++) {
//            index=(index+m-1)%list.size();
//            list.remove(index);
//        }
//        return list.get(0);
//    }

    @Test
    public void test() {
        lastRemaining(5, 3);
    }
}
