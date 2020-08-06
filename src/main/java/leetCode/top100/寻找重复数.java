package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数
 * @Author: YaYa
 * @Create: 2020-08-06 15:16
 */
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        slow = 0;
        while (slow == fast || nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
