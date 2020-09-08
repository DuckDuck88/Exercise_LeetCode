package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * @Author: YaYa
 * @Create: 2020-09-07 10:51
 */
public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        if (a.length == 0)
            return b;
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
