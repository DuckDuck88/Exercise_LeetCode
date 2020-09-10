package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 不相邻的最大和 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        String s = sc.nextLine();
        String[] ss = s.split(",");
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        System.out.println(dp[dp.length - 1]);
    }

}
