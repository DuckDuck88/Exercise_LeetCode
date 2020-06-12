package leetCode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @Author: YaYa
 * @Create: 2020-06-07 18:07
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] index = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i]=false;
        }
        helper(nums, result, index, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, boolean[] index, ArrayList tempList) {
        if (nums.length == 0) return;
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!index[i]){
                index[i]=true;
                tempList.add(nums[i]);
                helper(nums, result, index, tempList);
                index[i]=false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {};
        System.out.println(permute(nums));
    }
}
