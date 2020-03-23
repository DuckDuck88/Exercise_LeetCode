package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName MinArray
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-06 16:52
 */
public class MinArray {
    public int minArray(int[] numbers) {
        if (numbers.length==0) return -1;
//        for (int i = 0; i < numbers.length-1; i++) {
////            if (numbers[i]>numbers[i+1])
////                return numbers[i+1];
////        }
////        return numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]<numbers[0])
                return numbers[i];
        }
        return numbers[0];
    }
}
