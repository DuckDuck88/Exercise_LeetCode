package leetCode.top100;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Program: LeetCode
 * @Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 * @Author: YaYa
 * @Create: 2020-07-31 10:30
 */
public class 数组中的第K个最大元素 {
    /**
     * 快排
     *
     * @param nums
     * @param k
     * @return
     */
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
//        quickSort(nums, 0, nums.length - 1, nums.length - k);
//        return nums[nums.length - k];
        PriorityQueue<Integer> smallTopPile;
        if (k > nums.length / 2) {
            smallTopPile = new PriorityQueue<>((a, b) -> (b - a));
            for (int num : nums) {
                smallTopPile.add(num);
                if (smallTopPile.size() > nums.length - k + 1)
                    smallTopPile.poll();
            }
        } else {
            smallTopPile = new PriorityQueue<>();
            for (int num : nums) {
                smallTopPile.add(num);
                if (smallTopPile.size() > k)
                    smallTopPile.poll();
            }
        }
        return smallTopPile.peek();
    }
//快排
//    public void quickSort(int[] nums, int left, int right, int k) {
//        if (left >= right) return;
//        int l = left, r = right;
//        int index = nums[left];
//        while (l < r) {
//            while (l < r && nums[r] > index) {
//                r--;
//            }
//            swap(nums, l, r);
//            while (l < r && nums[l] <= index) {
//                l++;
//            }
//            swap(nums, l, r);
//        }
//        if (l < k) {
//            quickSort(nums, l + 1, right, k);
//        } else if (l > k) {
//            quickSort(nums, left, r - 1, k);
//        } else if (l == k) {
//            return;
//        }
//    }

//    private void swap(int[] nums, int l, int r) {
//        int temp = nums[l];
//        nums[l] = nums[r];
//        nums[r] = temp;
//    }

    /**
     * 快排
     * 确认标准，两个指针 index、pre。pre发现比标准小的数字则将其和index交换位置，index++。
     * 最后以index为分界点，根据index和target比较决定下一次遍历区间
     */
//    private void quickSort(int[] nums,int left,int right,int k){
//        int ran=random.nextInt(right-left+1)+left;
//        swap(nums, ran, right);
//        int pivot=nums[right];
//        int index=left;
//        for (int i = left; i < right; i++) {
//            if (nums[i]<pivot){
//                swap(nums, i, index++);
//            }
//        }
//        swap(nums, index, right);
//        if (index==k){
//            return;
//        }else if (index<k){
//            quickSort(nums, index+1, right, k);
//        }else if (index>k){
//            quickSort(nums, left, index-1, k);
//        }
//    }
    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 1));
    }
}
