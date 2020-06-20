package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串
 * @Author: YaYa
 * @Create: 2020-06-20 16:14
 */
public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (tLen > sLen || sLen == 0 || tLen == 0) return "";
        //频数数组   'c'=122;
        int[] freWin = new int[128];
        int[] freT = new int[128];
        for (int i = 0; i < tLen; i++) {
            freT[t.charAt(i)]++;
        }
        //distance记录窗口中有多少个t中的字符。
        int left = 0, right = 0, distance = 0, minLen = sLen + 1, begin = 0;
        while (right < sLen) {
            if (freT[s.charAt(right)] == 0) {
                right++;
                continue;
            }
            if (freWin[s.charAt(right)] < freT[s.charAt(right)]) {
                distance++;
            }
            freWin[s.charAt(right)]++;
            right++;

            while (distance == tLen) {

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                if (freT[s.charAt(left)] == 0) {
                    left++;
                    continue;
                }
                if (freWin[s.charAt(left)] == freT[s.charAt(left)]) {
                    distance--;
                }
                freWin[s.charAt(left)]--;
                left++;
            }
        }
        if (minLen == sLen + 1) return "";
        return s.substring(begin, begin + minLen);
    }
}
