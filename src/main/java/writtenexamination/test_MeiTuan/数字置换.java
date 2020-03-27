package writtenexamination.test_MeiTuan;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @ClassName 数字置换
 * @Description: 首先给出你一个整数，可能为正也可能为负，这个数字中仅包含数字1-9，
 * 现在定义一个1-9的置换，即指定将整数中的某个数字按顺序变换为另一个数字，
 * 请你输出变换以后的数字是多少。
 * 1234567
 * 9 8 7 6 5 4 3 2 1
 * 样例输出
 * 9876543
 * @Version 1.0
 * @Author: Mr.Liu9
 * @Create: 2020-03-26 19:04
 */
public class 数字置换 {
    public static void transform(){
        Scanner scanner=new Scanner(System.in);
        String num= scanner.nextLine();
        int[] a_=new int[9];
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < 9; i++) {
            a_[i]=scanner.nextInt();
        }
        boolean fushu=false;
        if (num.charAt(0)=='-'){
            result.append('-');
            fushu=true;
        }
        for (int i = 0; i < num.length(); i++) {
            if (i==0&&fushu)
                continue;
            //System.out.print(num.charAt(i));
            result.append((char)(a_[num.charAt(i)-48]+49));
        }
       // Integer.valueOf(String.valueOf(result));
        System.out.println(result);
    }


    public static void main(String[] args) {
        transform();
    }
}