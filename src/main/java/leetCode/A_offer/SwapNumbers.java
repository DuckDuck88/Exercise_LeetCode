package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName SwapNumbers
 * @Description: 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-07 00:42
 */
public class SwapNumbers {
//    public int[] swapNumbers(int[] numbers) {
//        numbers[0]=numbers[0]^numbers[1];
//        numbers[1]=numbers[0]^numbers[1];
//        System.out.println(numbers[1]);
//        numbers[0]=numbers[0]^numbers[1];
//        return numbers;
//    }

    public int[] swapNumbers(int[] numbers) {
        numbers[0]=numbers[0]+numbers[1];
        numbers[1]=numbers[0]-numbers[1];
        numbers[0]=numbers[0]-numbers[1];
    return numbers;
    }
}
