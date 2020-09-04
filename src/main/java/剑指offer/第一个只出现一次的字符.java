package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description: 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
 * @Author: YaYa
 * @Create: 2020-09-04 13:18
 */
public class 第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}
