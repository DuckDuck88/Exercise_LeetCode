package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author: YaYa
 * @Create: 2020-07-12 19:26
 */
public class 多数元素 {

//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map= new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//            if (map.get(nums[i])>nums.length/2){
//                return nums[i];
//            }
//        }
//        return nums[0];
//    }

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer condition = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                condition = nums[i];
            }
            count += nums[i] == condition ? 1 : -1;
            if (count > nums.length / 2) {
                return condition;
            }
        }
        return condition;
    }
}
