package leetCode.top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Program: LeetCode
 * @Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。  此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。  注意: 不能使用代码库中的排序函数来解决这道题  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-colors 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: YaYa
 * @Create: 2020-06-19 18:39
 */
public class 颜色分类 {
    /**
     * 排序 练习 快速排序，归并排序，堆排序
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1, curr = 0;
        while (curr <= two) {
            if (nums[curr] == 2) {
                swap(nums, curr, two);
                two--;
            } else if (nums[curr] == 0) {
                swap(nums, curr, zero);
                zero++;
                curr++;
            } else
                curr++;
        }
    }

    //快排,
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right || nums.length == 0 || nums == null) return;
        int l = left, r = right;
        int index = left;
        while (l < r) {
            while (nums[r] >= nums[index] && l < r) r--;
            while (nums[l] <= nums[index] && l < r) l++;
            swap(nums, l, r);
        }
        swap(nums, left, l);
        quickSort(nums, left, l);
        quickSort(nums, l + 1, right);
    }

    //归并
    public int[] merger(int[] nums, int left, int right) {
        if (left == right) return Arrays.copyOfRange(nums, left, right + 1);
        int mid = (left + right) / 2;
        int[] la = merger(nums, left, mid);
        int[] ra = merger(nums, mid + 1, right);
        return helper(la, ra);
    }

    private int[] helper(int[] la, int[] ra) {
        int[] result = new int[la.length + ra.length];
        int l = 0, r = 0, index = 0;
        while (l < la.length && r < ra.length) {
            if (la[l] < ra[r]) {
                result[index++] = la[l++];
            } else {
                result[index++] = ra[r++];
            }
        }
        while (l < la.length && r >= ra.length) {
            result[index++] = la[l++];
        }
        while (l >= la.length && r < ra.length) {
            result[index++] = ra[r++];
        }
        return result;
    }




    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    @Test
    public void test() {
        int[] te = {2, 0, 0, 1, 1, 2, 2, 1, 1, 0, 0, 2};
        sortColors(te);
        for (int i = 0; i < te.length; i++) {
            System.out.println(te[i]);
        }
    }
}
