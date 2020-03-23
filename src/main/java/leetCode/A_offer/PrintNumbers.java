package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName PrintNumbers
 * @Description: 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 17:58
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int [] result=new int[(int) Math.pow(10, n)];
        for (int i=1;i<result.length;i++){
            result[i-1]=i;
        }
        return result;
    }
}
