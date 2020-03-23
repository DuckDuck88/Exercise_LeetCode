package leetCode.nums;

import org.junit.Test;

/*
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
* */
public class Solution_3 {
    /**
    * @Description:
    * @params : [nums, k]
    * @Return : void
    * @Author : Mr.Liu
    * @Date : 2020/2/13
    */
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
//一.使用环形法
//        int times=1;    //移动次数
//        for (int start=0;times<=len;start++){
//            int cur=start;      //代替start
//            int pre=nums[start];//pre
//            do {
//                int next=(cur+k)%len;
//                int temp=nums[next];
//                nums[next]=pre;
//                pre=temp;
//                cur=next;
//                times++;
//            }while (start!=cur);
//        }

//        //二.反转数组法，整体反转，前k反转，后k反转
//        reverse(nums, 0, len-1);
//        reverse(nums, 0, k-1);
//        reverse(nums, k, len-1);


    }


    /**
    * @Description: 数组反转,用于第二种方法的辅助
    * @Params: [nums, start, end]
    * @Return: int[]
    * @Author: Mr.Liu
    * @Date: 2020/2/14
    */
    public int [] reverse(int [] nums,int start,int end){
        while (start<end){
            int temp=nums[end];
            nums[end]=nums[start];
            nums[start]=temp;
            start++;
            end--;
        }
        return nums;
    }

    @Test
    public void testDemo(){
        int [] aaa={1,2,3,4,5};
        System.out.println(reverse(aaa, 0, 4));
    }
}
