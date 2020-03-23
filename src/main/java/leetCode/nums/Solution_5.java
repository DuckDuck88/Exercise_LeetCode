package leetCode.nums;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName Solution_5
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。  说明：  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-14 16:59
 */
public class Solution_5 {
    public int singleNumber(int[] nums) {
//        因为要进行查询，首先考虑到查询时间复杂度为O（1）的哈希表。只需要遍历数组一次。但是会增加额外的空间。
//        int result=0;
//        Map<Integer,Integer> map=new HashMap<>(nums.length);
//        for (int i:nums){
//            if (map.containsKey(i)){
//                map.put(i, 2);
//            }else {
//                map.put(i, 1);
//            }
//        }
//        for (Map.Entry<Integer,Integer> m:map.entrySet()){
//            if (m.getValue()==1)
//                result=m.getKey();
//        }
//        return result;

        //利用异或运算，因为相同数字异或为0，只需要将所有数字进行异或，得到的为最终的数字
        int result=0;
        for (int num:nums){
            result=result ^ num;
        }
        return result;
    }

    @Test
    public void testDemo(){
        int[] nums={1,2,1,2,3};
        System.out.println(singleNumber(nums));
    }
}
