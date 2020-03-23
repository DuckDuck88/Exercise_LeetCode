package leetCode.nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Program: LeetCode
 * @ClassName Solution_6
 * @Description: 给定两个数组，编写一个函数来计算它们的交集。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-14 18:01
 */
public class Solution_6 {
//    //方法一：利用哈希表，计算交集首先需要遍历数组，考虑使用哈希表
//    public int[] intersect(int[] nums1, int[] nums2) {
//        int[] nums=new int[nums1.length>nums2.length?nums2.length:nums1.length];
//        //使用哈希表，key为数字，value计数
//        Map<Integer,Integer> map=new HashMap<>(nums.length);
//        for (int i:nums1){
//            if (map.containsKey(i)){
//                map.put(i,map.get(i)+1);//如果存在则计数加一
//            }else {
//                map.put(i, 1);
//            }
//        }
//        int k=0;//结果数组的计数
//        for (int i:nums2){
//            if (map.containsKey(i)&&map.get(i)>0){
//                nums[k++]=i;
//                map.put(i, map.get(i)-1);
//            }
//        }
//        return Arrays.copyOfRange(nums, 0, k);
//    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }else {
                nums1[k++]=nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    @Test
    public void testDemo(){
        int [] a={4,9,5};
        int [] b={9,4,9,8,4};
        System.out.println(intersect(a, b));
    }
}
