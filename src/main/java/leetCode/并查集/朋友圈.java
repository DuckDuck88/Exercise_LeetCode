package leetCode.并查集;

import org.junit.Test;

/*
班上有N名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B的朋友，
B 是 C的朋友，那么我们可以认为 A 也是 C的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个N * N的矩阵M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 */
public class 朋友圈 {
    /*
     * @description:
     * @param: 朋友关系
     * @return: 朋友圈数量
     * @date: 2020/9/14 19:41
     * @created by 是哪的鸭
     */
    public int findCircleNum(int[][] M) {
        int len = M.length;
        if (len == 0) return 0;
        int[] cas = new int[len];
        for (int i = 0; i < len; i++) {
            cas[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //构造并查集
                if (M[i][j] == 1) {
                    union(cas, i, j);
                }
            }
        }
        int cont = 0;
        for (int i = 0; i < len; i++) {
            if (cas[i] == i)
                cont++;
        }
        return cont;
    }

    private void union(int[] cas, int i, int j) {
        int parenti = find(cas, i);
        int parentj = find(cas, j);
        if (parenti != parentj)
            cas[parenti] = parentj;
    }

    private int find(int[] cas, int i) {
        if (cas[i] == i) return i;
        return cas[i] = find(cas, cas[i]);
    }

    @Test
    public void myTest() {
        System.out.println(findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
    }
}
