package leetCode.nums;

import java.util.HashSet;
import java.util.Set;

/**
 * @Program: LeetCode
 * @ClassName Solution_4
 * @Description: 给定一个整数数组，判断是否存在重复元素。
 *               如果任何值在数组中出现至少两次，函数返回 true。
 *               如果数组中每个元素都不相同，则返回 false。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-14 01:17
 */
public class Solution_4 {
    public boolean containsDuplicate(int[] nums) {
// 方法一：先排序，然后临近的
        //        Arrays.sort(nums);
//        int i=0;
//        while (i<nums.length){
//            if (i==nums.length-1)
//                return false;
//            if (nums[i]==nums[i+1])
//                return true;
//            i++;
//        }
//        return false;

        //方法二  因为要进行search操作，所以考虑使用集合框架
        // 二叉搜索树treeset和treemap和哈希表hashmap和hashset查找很快
        //但是我们还需要进行数据的插入操作，二叉搜索树插入操作的时间复杂度为log(n)，所以采用哈希表
        Set<Integer> set=new HashSet<>(nums.length);
        for (int i:nums){
            if (set.contains(i))
                return true;
            set.add( i);
        }
        return false;
    }
}
