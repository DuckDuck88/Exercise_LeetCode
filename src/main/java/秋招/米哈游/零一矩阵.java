package 秋招.米哈游;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description:
 * @Author: YaYa
 * @Create: 2020-08-21 21:33
 * 4 4
 * 0 0 0 1
 * 1 0 0 0
 * 1 1 1 0
 * 0 0 0 0
 */
public class 零一矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] marrage = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                marrage[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int[] result = new int[N];
            for (int j = i; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    result[k] += marrage[j][k];
                }
                if (result[0] == result[1] && result[1] == result[2] && result[2] == result[3]) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
