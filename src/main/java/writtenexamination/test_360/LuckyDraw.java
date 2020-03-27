package writtenexamination.test_360;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @ClassName LuckyDraw
 * @Description: A和B两个人在抽奖。现在有一个抽奖箱，里面有n张中奖票，m张不中奖票。A和B轮流从中抽一张奖票出来。如果有人抽到中奖票就结束，抽到中奖票的人胜利。抽过的奖票会被丢弃。  额外的，B每次抽后，会再次抽取一张票并丢弃掉（这张票中奖不算B胜利）。  现在，A先抽，请问A的胜率，保留4位小数后输出。  如果两人到最后也没有抽到中奖票算作B胜利。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-24 20:24
 */
public class LuckyDraw {
    public static void main(String[] args) {
        /*
         *  2 3  0.6000
         * */
        /*
        * 样例输入2
1 3
样例输出2
0.5000
样例二解释：
如果A第一轮抽到中奖票，A胜利，概率0.25。
如果A第二轮抽到中奖票，情况为A第一轮没有抽到中奖票，B也没有抽到中奖票，并且B丢弃掉的奖票也不是中奖票。概率为3/4 * 2/3 * 1/2=0.25
综上，中奖率为0.5。
        * */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //中奖
        int m = scanner.nextInt(); //不中奖
        int sum = n + m;
        double winRate = 0;
        boolean x = false;
        winRate = (double) n / sum;
        while (m >= 3) {
            if (x)
                winRate = winRate * (double) n / sum;
            x = true;
            winRate = winRate + helper(m--, sum--) * helper(m--, sum--) * helper(m--, sum--);
        }
        if (m > 0 && m < 3)
            winRate = winRate + (double) (n / sum);
        System.out.println(String.format("%.4f", winRate));
    }

    public static double helper(int a, int b) {
        return (double) a / (double) b;
    }


    @Test
    public void test() {
        System.out.println(helper(3, 5) * helper(2, 4) * helper(1, 3));
    }
}