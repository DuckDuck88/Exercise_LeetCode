package leetCode.top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Program: LeetCode
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：  左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @Author: YaYa
 * @Create: 2020-04-30 20:12
 */
public class 有效的括号 {
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};

    public boolean isValid(String s) {
        if (s.equals("")) return true;
        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()){
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char top=stack.peek();
                if (stack.isEmpty()||c!=map.get(top)){
                    //stack.pop();
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    @Test
    public void test(){
        String s="]";
        System.out.println(isValid(s));
    }
}
