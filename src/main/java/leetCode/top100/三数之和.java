package leetCode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组
 * @Author: YaYa
 * @Create: 2020-04-29 17:54
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums==null||nums.length < 3) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left<right&&(nums[left]==nums[left+1])) left++;
                    while (right>left&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                } else if (temp > 0) {
                    right--;
                } else if (temp < 0) {
                    left++;
                }
            }
        }
        return lists;
    }
    @Test
    public void test(){
        int nums[]={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
