package leetCode.B_db_sort_death;

/**
 * @Program: LeetCode
 * @ClassName MaxValue
 * @Description: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-24 17:22
 */
public class MaxValue {
    //动态规划
    //    public int maxValue(int[][] grid) {
//        int[][] value = grid;
//        //状态转移。value[i][j]=value[i][j-1]+value[i-1][j-1]+value[i][j]
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (i==0&&j==0) continue;
//                else if (i==0&&j!=0) value[i][j]=value[0][j-1]+value[i][j];
//                else if (i!=0&&j==0) value[i][j]=value[i-1][0]+value[i][j];
//                else value[i][j]=Math.max(value[i-1][j],value[i][j-1])+value[i][j];
//            }
//        }
//        return value[grid.length - 1][grid[0].length - 1];
//    }

    //动态规划优化
    /*
    *  我是憨逼
    * */
    public int maxValue(int[][] grid){
        int[] value=new int[grid[0].length+1];
        value[0]=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                value[j+1]=Math.max(value[j+1],value[j])+grid[i][j];
            }
        }
        return value[grid[0].length];
    }
}
