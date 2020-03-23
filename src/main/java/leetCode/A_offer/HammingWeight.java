package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName HammingWeight
 * @Description: 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-06 17:44
 */
public class HammingWeight {
//    public int hammingWeight(int n) {
//        int itotal=0;
//        while (n!=0){
//            if ((n&1)==1){
//                itotal++;
//            }
//            n= n >>> 1 ;
//        }
//        return itotal;
//    }
    public int hammingWeight(int n) {
        int total=0;
        while (n!=0){
            n=n&(n-1);
            total++;
        }
        return total;
    }
}
