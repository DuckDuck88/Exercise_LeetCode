package 秋招.百度;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description: n头牛，1-n，m种特点，满足所有的为优质奶牛。某种特性，存在几段连续的满足，
 * @Author: YaYa
 * @Create: 2020-09-03 19:32
 */
public class 优质奶牛 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            //存放m个特性
            List<int[]>[] mm = new List[m];
            //每个特性的区间
            //List<int[]> qj=new ArrayList<>();
            int x = 0;
            while (x < m) {
                int k = sc.nextInt();
                mm[x] = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    int[] t = new int[2];
                    t[0] = sc.nextInt();
                    t[1] = sc.nextInt();
                    mm[x].add(t);
                }
                x++;
            }
            int[] result = new int[n + 1];
            for (int i = 0; i < mm.length; i++) {
                for (int[] arr : mm[i]) {
                    for (int j = arr[0]; j <= arr[1]; j++) {
                        result[j]++;
                    }
                }
            }
            int res = 0;
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < result.length; i++) {
                if (result[i] == m) {
                    res++;
                    r.add(i);
                }
            }
            System.out.println(res);
            for (Integer integer : r) {
                System.out.print(integer + " ");
            }
            if (T > 1)
                System.out.println();
            T--;
        }
    }
}
