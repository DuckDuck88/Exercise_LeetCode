package leetCode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。  说明：解集不能包含重复的子集
 * @Author: YaYa
 * @Create: 2020-06-20 20:43
 */
public class 子集 {
    //迭代
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result=new ArrayList<>();
//        result.add(new ArrayList<Integer>());
//
//        for (int num:nums){
//            List<List<Integer>> temp=new ArrayList<>();
//
//            for(List<Integer> list:result){
//                temp.add(new ArrayList<Integer>(list){{add(num);}});
//            }
//            for (List list:temp){
//                result.add(list);
//            }
//        }
//        return result;
//    }

    //回溯
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        //for (int i = 0; i < nums.length + 1; i++) {
//            helper(result, new ArrayList<Integer>(), nums, 0);
//        //}
//        return result;
//    }
//
//    public void helper(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, int start) {
//        //if (list.size() == len) {
//            result.add(new ArrayList<>(list));
////            return;
////        }
//        for (int i = start; i < nums.length; i++) {
//            list.add(nums[i]);
//            helper(result, list, nums, i + 1);
//            list.remove(list.size() - 1);
//        }
//    }

    //二进制
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i>>j&1)==1) list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }


    @Test
    public void test() {
        int nums[]={1,2,3};
        System.out.println(subsets(nums));
    }
}
