package leetCode.sort;

/**
 * @Program: LeetCode
 * @ClassName Merge
 * @Description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，
 * 使得 num1 成为一个有序数组。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-26 15:04
 */
public class Merge {
    //方法一：引入额外空间，双指针法
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] nums=new int[nums1.length];
//        int[] index1=nums1;
//        int[] index2=nums2;
//        int index=0;
//        int i=0,j=0;
//        while (i<m||j<n){
//            if (i>=m){
//                nums[index++]=nums2[j++];
//            }else if (j>=n){
//                nums[index++]=nums1[i++];
//            }else if (nums1[i]<=nums2[j]){
//                    nums[index++]=nums1[i++];
//            } else {
//                nums[index++]=nums2[j++];
//            }
//        }
//        for (int x=0;x<nums.length;x++){
//            nums1[x]=nums1[x];
//        }
//    }
    //方法二：将方法一稍加改变。引入额外空间放置数组1的前m位
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] nums=new int[m];
//        System.arraycopy(nums1, 0, nums, 0, m);
//        int i=0,j=0;
//        int index=0;
//        while (i<m && j<n){
//            nums1[index++]=nums[i]>nums2[j]?nums2[j++]:nums[i++];
//        }
//        if (i<m){
//            System.arraycopy(nums,i,nums1, index, m-i);
//        }
//        if (j<n){
//            System.arraycopy(nums2, j, nums1, index, n-j);
//        }
//    }

    //方法三：从后往前
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        int i=m-1,j=n-1;
        while (i>=0&&j>=0){
                nums1[index--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j+1);
    }

}
