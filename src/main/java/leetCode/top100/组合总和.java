package leetCode.top100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
 * @Author: YaYa
 * @Create: 2020-06-03 20:31
 */
public class 组合总和 {
    int x = 0;
    /**
     * @description: 回溯
     * @param: [candidates, target]
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     * @Author: YaYa
     * @Date: 2020/6/3
     */
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result=new ArrayList<>();
//        Arrays.sort(candidates);
//        helper(result, new ArrayList(), candidates, target,0);
//        return result;
//    }
//    public void helper(List<List<Integer>> result,List tempList,int[] candidates,int target,int start){
//        if (target<0) return;
//        else if (target==0) result.add(new ArrayList<>(tempList));
//        else {
//            for (int i = start; i < candidates.length; i++) {
//                tempList.add(candidates[i]);
//                helper(result, tempList, candidates, target-candidates[i],i);
//                tempList.remove(tempList.size()-1);
//            }
//        }
//    }

    /**
     * 贪心算法
     */
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(candidates);
//        helper(result, new ArrayList<>(), candidates, target, candidates.length - 1);
//        return result;
//    }
//
//    /**
//     * @param result     存放结果数组
//     * @param tempList   每行的数据
//     * @param candidates 目标数组
//     * @param target     目标数字
//     * @param start      每次循环的起始位置，
//     */
//    private void helper(List<List<Integer>> result, List tempList, int[] candidates, int target, int start) {
//        if (target == 0) result.add(new ArrayList<>(tempList));
//        else if (target < 0 || start < 0) return;
//        else {
//            int max = target / candidates[start];
//            for (int j = 0; j < max; j++) {
//                tempList.add(candidates[start]);
//            }
//            for (int j = max; j >= 0; j--) {
//                helper(result, tempList, candidates, target - candidates[start] * j, start - 1);
//                if (j > 0) tempList.remove(tempList.size() - 1);
//            }
//        }
//    }

    /**
     * @description: 回溯+剪枝
     * @param: [candidates, target]
     * @return:
     * @Author: YaYa
     * @Date: 2020/6/7
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, new ArrayDeque());
        return result;
    }

    /**
     * @param candidates 目标数组
     * @param target     目标数字
     * @param start      遍历起始位置，防止重复
     * @param result     结果集
     * @param tempList   记录单此结果
     */
    private void helper(int[] candidates, int target, int start, List<List<Integer>> result, Deque tempList) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                if (target-candidates[i]<0)
                    break;
                tempList.addLast(candidates[i]);
                x++;
                helper(candidates, target-candidates[i],i,result, tempList);
                tempList.removeLast();
            }
        }
    }

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target).toString());
        System.out.println(x);
    }
}
