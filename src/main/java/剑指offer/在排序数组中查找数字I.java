package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 统计一个数字在排序数组中出现的次数。
 * @Author: YaYa
 * @Create: 2020-09-07 11:16
 */
public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int res = 0;
        int index = -1;
        int mid = index;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                res++;
                break;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (index == -1)
            return res;
        int t = mid + 1;
        while (t < nums.length && nums[t] == target) {
            res++;
            t++;
        }
        int t1 = mid - 1;
        while (t >= 0 && nums[t] == target) {
            res++;
            t--;
        }
        return res;
    }
}
