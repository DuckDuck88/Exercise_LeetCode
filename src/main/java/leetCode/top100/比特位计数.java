package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 * @Author: YaYa
 * @Create: 2020-08-20 13:37
 */
// 1 2 4 8 16
public class 比特位计数 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
//        for (int i = 0; i < num+1; i++) {
//            result[i]=helper(i);
//        }
//        return result;

        //O(n)
//        int b = 1, i = 0;
//        while (b < num + 1) {
//            while (i < b && i + b <= num) {
//                result[i + b] = result[i] + 1;
//                i++;
//            }
//            i = 0;
//            b<<=1;
//        }
//        return result;

        for (int i = 1; i < num + 1; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    //不断移位版本
//    private int helper(int x){
//        int res=0;
//        while (x!=0){
//            if ((x&1)==1){
//                res++;
//            }
//            x>>=1;
//        }
//        return res;
//    }

//    private int helper(int x){
//        int res;
//        for (res=0;x!=0;res++){
//            x&=x-1;
//        }
//        return res;
//    }


}
