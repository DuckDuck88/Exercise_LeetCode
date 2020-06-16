package leetCode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 给出一个区间的集合，请合并所有重叠的区间
 * @Author: YaYa
 * @Create: 2020-06-16 22:52
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) return new int[0][];
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length;i++ ) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] < right) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{left, right});
        }
        return result.toArray(new int[0][]);
    }

    @Test
    public void test() {
        int[][] te = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(merge(te)[0][0]);
    }
}
