package 秋招.B站;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Program: LeetCode
 * @Description: 判断给出的字符串是否有效
 * @Author: YaYa
 * @Create: 2020-08-13 19:51
 */
public class 括号匹配 {

    public boolean IsValidExp(String s) {
        //一个栈 所有左括号入栈  遇到右括号弹出，匹配则继续 不匹配则报错
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char temp = stack.pop();
                if (c != map.get(temp)) {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    @Test
    public void test() {
        String s = "({})}";
        System.out.println(IsValidExp(s));
    }
}
