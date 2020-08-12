package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串
 * @Author: YaYa
 * @Create: 2020-08-12 11:19
 */
public class 回文子串 {
    //中心扩展法
    //    public int countSubstrings(String s) {
//        int len = s.length();
//        if (len < 1) return len;
//        int result = 0;
//        //有两种回文子串，一种长度为奇数，一种长度为偶数。
//        for (int i = 0; i < len; i++) {
//            //奇数情况
//            result+=palindrome(s, i, i);
//            //偶数情况
//            int j = i + 1;
//            result+=palindrome(s, i, j);
//        }
//        return result;
//    }
//
//    private int palindrome(String s, int l, int r) {
//        int len = s.length();
//        if (r >= len) return 0;
//        int result=0;
//        boolean flag=true;
//        while (l >= 0 && r < len  && flag) {
//            if (s.charAt(l) == s.charAt(r)) {
//                result++;
//                l--;
//                r++;
//            }else {
//                flag=false;
//            }
//        }
//        return result;
//    }

    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        countSubstrings("abc");
    }
}
