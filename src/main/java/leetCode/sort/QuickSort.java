package leetCode.sort;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName QuickSort
 * @Description: 快速排序
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-26 11:26
 */
public class QuickSort {

    public void queickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int temp = nums[left];
        int i = left, j = right;
        //遍历找到中间
        while (i < j) {
            while (j > i && nums[j] > temp) {
                j--;
            }
            swap(nums, i, j);
            while (i < j && nums[i] <= temp) {
                i++;
            }
            //交换数字
            swap(nums, i, j);
        }
        //前半段继续遍历
        queickSort(nums, left, i - 1);
        //后半段继续遍历
        queickSort(nums, i+1, right);
        return;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    @Test
    public void test() {
        int[] nums = {1, 5, 4, 3, 2, 8, 4, 0, 8, 0, 5, 4, 1, 0, 1};
        queickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
