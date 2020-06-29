package leetCode.top100;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Program: LeetCode
 * @Description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词
 * @Author: YaYa
 * @Create: 2020-06-29 21:02
 */
public class 单词拆分 {
    /**
     * 动态规划 d[i]表示前i个字母会出现在字典中。两种递推法，j的含义不同
     * j表示前i个字母中的间隔 0->i
     * d[i]=d[j]&&wordeDict.contains(s.subString(j,i)); 时间复杂度 n！
     * j表示wordDict.size() 0->size
     * d[i]=d[j]&&word.get(j).equal(s.subString(j,i));  时间复杂度 size的n次方 （可剪枝）
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        if (length == 0) return true;
        boolean dp[] = new boolean[length + 1];
        dp[0] = true;
        Set<String> stringSet = new HashSet<>(wordDict);
        for (int i = 1; i < length + 1; i++) {
            //第一种动态写法
//          for (int j = 0; j <= i; j++) {
//              if (dp[j] && stringSet.contains(s.substring(j, i))) {
//                  dp[i] = true;
//                  break;
//              }
//
            for (String s1 : stringSet) {
                int len = s1.length();
                if (i >= len && dp[i - len] && s1.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        Set<String> stringSet = new HashSet<>(wordDict);
        Set<Integer> integerSet = new HashSet<>();
        helper(s, stringSet, integerSet, 0);
        return helper(s, stringSet, integerSet, 0);
    }

    private boolean helper(String s, Set<String> stringSet, Set<Integer> integerSet, int start) {
        if (start == s.length()) return true;
        if (integerSet.contains(start))
            return false;
        for (int end = start+1; end <= s.length(); end++) {
            if (stringSet.contains(s.substring(start, end))) {
                if (helper(s, stringSet, integerSet, end)) {
                    return true;
                }
                integerSet.add(end);
            }
        }
        return false;
    }

    @Test
    public void test() {
        String s = "leetcode";
        System.out.println(s.substring(0, 3));
    }
}
