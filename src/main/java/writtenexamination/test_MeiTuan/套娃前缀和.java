package writtenexamination.test_MeiTuan;

/**
 * @Program: LeetCode
 * @ClassName 套娃前缀和
 * @Description: 套娃最近很流行，小美想知道前缀和是否也可以进行套娃操作。
 * 小美现在想知道能否快速求解
 * 输入
 * 4 3
 * 1 0 0 0
 * 样例输出
 * 10
 *
 * 提示
 * 样例解释，需要三次求和：
 * 第一次：sum[1][1] = sum[0][1] = 1, sum[1][2] = sum[0][1] + sum[0][2] = 1, sum[1][3] = sum[0][1] + sum[0][2] + sum[0][3] = 1, sum[1][4] = sum[0][1] + sum[0][2] + sum[0][3] + sum[0][4] = 1. sum[1][] = { 1, 1, 1, 1 };
 * 第二次：sum[2][] = { 1, 2, 3, 4 }.
 * 第三次：sum[3][] = { 1, 3, 6, 10 }.
 * 故sum[K][N] = sum[3][4] = 10
 *
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-26 20:26
 */
public class 套娃前缀和 {
    
}
