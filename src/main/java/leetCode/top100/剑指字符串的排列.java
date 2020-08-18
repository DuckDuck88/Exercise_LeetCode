package leetCode.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Program: LeetCode
 * @Description: 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @Author: YaYa
 * @Create: 2020-08-14 15:21
 */
public class 剑指字符串的排列 {

    public String[] permutation(String s) {
        if (s.length() == 0) return new String[0];
        Set<String> result = new HashSet<>();
        result = helper(s, 0, new StringBuilder(), result);
        String[] res = new String[result.size()];
        return result.toArray(res);
    }

    private Set<String> helper(String s, int index, StringBuilder sb, Set<String> result) {
        if (index == s.length())
            result.add(String.valueOf(sb));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(s, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        return result;
    }

}
