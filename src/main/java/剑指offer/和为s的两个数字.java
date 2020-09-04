package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * @Author: YaYa
 * @Create: 2020-09-04 10:09
 */
public class 和为s的两个数字 {

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i]) && ((nums[i] != target - nums[i]) || map.get(nums[i])>1)) {
//                return new int[]{nums[i], target - nums[i]};
//            }
//        }
//        return new int[]{};
//    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int res = nums[left] + nums[right];
            if (res == target)
                return new int[]{nums[left], nums[right]};
            else if (res > target)
                right--;
            else
                left++;
        }
        return new int[]{};
    }
}
