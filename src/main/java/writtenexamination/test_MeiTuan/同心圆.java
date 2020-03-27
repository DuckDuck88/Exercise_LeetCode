package writtenexamination.test_MeiTuan;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @ClassName 同心圆
 * @Description: 有这么一个奇怪的符号：在一张正方形的纸上，有许多不同半径的圆。他们的圆心都在正方形的重心上（正方形的重心位于正方形两条对角线的交叉点上）。  最大的圆的外面部分是白色的。最外层的圆环被涂成了黑色，接下来第二大的圆环被涂层白色，接下来第三大的圆环被涂层黑色。以此类推，例如下图。  现在，给你这些圆的半径，请问黑色部分的面积是多少？精确到小数点后5位输出（四舍五入）。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-26 19:49
 */
public class 同心圆 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int n= Integer.valueOf(s);
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        double mianji=0;
        if (n%2==0){
            for (int i = 1; i < n; i=i+2) {
                mianji=mianji+mj(nums, i);
            }
        }else {
            for (int i=0;i<n;i=i+2){
                if (i==0){
                    mianji=Math.PI*nums[0]*nums[0];
                    continue;
                }
                mianji=mianji+mj(nums, i-1);
            }
        }
        System.out.println(String.format("%.5f", mianji));
    }

    public static double mj(int[] nums,int i){
        double mianji=0;
        mianji=Math.PI*(nums[i+1]*nums[i+1]-nums[i]*nums[i]);
        return mianji;
    }
}
