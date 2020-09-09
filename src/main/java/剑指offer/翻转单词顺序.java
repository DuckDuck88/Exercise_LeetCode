package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * @Author: YaYa
 * @Create: 2020-09-09 11:19
 */
public class 翻转单词顺序 {
    public String reverseWords(String s) {
        if (s.length() == 0) return "";
        s = s.trim();
        int left = s.length() - 1, right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') left--;
            sb.append(s.substring(left + 1, right + 1) + ' ');
            while (left >= 0 && s.charAt(left) == ' ') left--;
            right = left;
        }
        return sb.toString().substring(0, sb.length());
    }
}
