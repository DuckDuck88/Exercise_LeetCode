package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName 盛水最多的容器
 * @Description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-04-18 16:12
 */
public class 盛水最多的容器 {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int res=0;
        while (left<right){
            res=Math.max(res, area(height,left,right));
            if (height[left]<height[right])
                left++;
            else
                right--;
        }
        return res;
    }

    private int area(int[] height, int left, int right) {
        return (right-left)*(height[left]>height[right]?height[right]:height[left]);
    }

    @Test
    public  void test(){
        int i[]={1,8,6,2,5,4,8,3,7};
        maxArea(i);
    }
}
