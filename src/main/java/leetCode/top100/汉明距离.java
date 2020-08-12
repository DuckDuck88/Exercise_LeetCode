package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离
 * @Author: YaYa
 * @Create: 2020-08-11 14:00
 */
public class 汉明距离 {
//    public int hammingDistance(int x, int y) {
//        int result=0;
//        String x1=Integer.toBinaryString(x);
//        String y1=Integer.toBinaryString(y);
//        for (int i = x1.length()-1,j=y1.length()-1; i>=0||j>=0 ; i--,j--) {
//            if (i<0 && j>=0)
//                result+=y1.charAt(j)=='1'?1:0;
//            else if (i>=0&&j<0)
//                result+=x1.charAt(i)=='1'?1:0;
//            else
//                result+=x1.charAt(i)==y1.charAt(j)?0:1;
//        }
//        return result;
//    }

    /**
     * 两种移位方法
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int result = 0;
//        while (n!=0){
//            if ((n&1)==1){
//                result++;
//            }
//            n=n>>>1;
//        }
//        return result;
        while (n != 0) {
            result++;
            n = n & (n - 1);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(hammingDistance(1, 4));
    }
}
