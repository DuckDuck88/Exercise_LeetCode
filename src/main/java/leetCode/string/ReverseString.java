package leetCode.string;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName ReverseString
 * @Description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-15 12:42
 */
public class ReverseString {
    //方法一，暴力法
//    public void reverseString(char[] s) {
//        for (int i=0;i<s.length/2;i++){
//            char temp;
//            temp=s[i];
//            s[i]=s[s.length-1-i];
//            s[s.length-1-i]=temp;
//        }
//        for (char c : s) {
//            System.out.println(c);
//        }
//    }

    //方法二，双指针法
    public void reverseString(char[] s) {
        int start=0,end=s.length-1;
        while (start<end){
            char temp;
            temp=s[start];
            s[start++]=s[end];
            s[end--]=temp;
        }
    }

    @Test
    public void testDemo(){
        char[] a={'h','e','l','l','o'};
        int [] b={1,2,3,4};
        reverseString(a);
        System.out.println(a);
    }
}
