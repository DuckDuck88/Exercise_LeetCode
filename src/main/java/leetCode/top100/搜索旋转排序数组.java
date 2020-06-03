package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。  你的算法时间复杂度必须是 O(log n) 级别。  来
 * @Author: YaYa
 * @Create: 2020-06-03 10:48
 */
public class 搜索旋转排序数组 {
    /**
    * @description: 寻找到旋转点，然后分别二分查找。
    * @params: [nums, target]
    * @return: int
    * @Author: Mr.Liu
    * @Date: 2020/6/3
    */
    public int search(int[] nums, int target) {
        if ((nums.length==1&&target!=nums[0])||nums.length==0) return -1;
        int index=0; //标记旋转点
        while (index+1<nums.length&&nums[index]<nums[index+1]){
            index++;
        }
        if (target>=nums[0]){
            return binarySearch(nums, 0, index, target);
        }else {
            return binarySearch(nums, index+1, nums.length-1, target);
        }
    }

    //二分查找
    private int binarySearch(int[] nums,int left,int right,int target){
        if (((left==right)&&nums[left]!=target)||left>right)  return -1;
        int mid=(left+right)/2;
        if (target==nums[mid]){
            return mid;
        }else if(target>nums[mid]){
            return binarySearch(nums, mid+1, right, target);
        }else {
            return binarySearch(nums, left, mid-1, target);
        }
    }

    @Test
    public void testDemo(){
        int nums[]={4,5,6,7,0,1,2};
        int target=3;
        System.out.println(search(nums, target));
    }
}
