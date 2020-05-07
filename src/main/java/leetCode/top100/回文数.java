package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description:
 * @Author: YaYa
 * @Create: 2020-04-27 22:51
 */
public class 回文数 {
    // 解法一,转换为字符串，反转字符串比较
//    public boolean isPalindrome(int x) {
//        String str=(new StringBuilder(x+"")).reverse().toString();
//        return (x+"").equals(str);
//    }

    //解法二  双指针同时比较
//    public boolean isPalindrome(int x) {
//        if (x<0) return false;
//        int len=1;
//        while(x/len>=10) {
//            len*=10;
//        }
//
//        while (x>0){
//            int left=x/len;
//            int right=x%10;
//            if (left!=right) return false;
//            x=(x%len)/10;
//            len/=100;
//        }
//        return true;
//    }


        
    @Test
    public void test(){
        int x=121;
        //isPalindrome(x);
    }


}
