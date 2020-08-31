package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author: YaYa
 * @Create: 2020-08-31 10:34
 */
public class 数组中出现次数超过一半的数字 {
//    public int majorityElement(int[] nums) {
//        Map<Integer,Integer> res=new HashMap();
//        for (int i = 0; i < nums.length; i++) {
//            int num=res.getOrDefault(nums[i],0)+1;
//            if (num>=nums.length/2)
//                return nums[i];
//            res.put(nums[i],num);
//        }
//        return 0;
//    }

    //    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        int x=nums[nums.length/2];
//        return x;
//    }
    public int majorityElement(int[] nums) {
        int x = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == 0)
                x = nums[i];
            if (nums[i] != x)
                res -= 1;
            else
                res += 1;
        }
        return x;
    }

}
