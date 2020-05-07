package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName 最长回文子串
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-04-17 21:41
 */
public class 最长回文子串 {
    //中心扩展法
    public String longestPalindrome(String s) {
        if (s==null||s.length()==0) return "";
        int l=0,r=0;
        for (int i = 0; i < s.length(); i++) {
            int len1=centerExtension(s, i, i);
            int len2=centerExtension(s, i, i+1);
            int len=Math.max(len1, len2);
            if (len>r-l){
                l=i-(len-1)/2;
                r=i+len/2;
            }
        }
        return s.substring(l, r);
    }

    private int centerExtension(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    @Test
    public void test(){
        longestPalindrome("babad");
    }
}
