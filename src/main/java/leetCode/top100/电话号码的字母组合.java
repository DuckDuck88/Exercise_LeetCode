package leetCode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * @Author: YaYa
 * @Create: 2020-04-30 16:37
 */
public class 电话号码的字母组合 {
    private static Map<Character,String> map=new HashMap<>();
    List<String> list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return list;
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backUpon(digits,0,new StringBuilder(""));
        return list;
    }

    public void backUpon(String digits,int index,StringBuilder sb){
        if (index==digits.length()) {
            list.add(String.valueOf(sb));
            return;
        }
        Character c=digits.charAt(index);
        String letter=map.get(c);
        for (int i = 0; i < letter.length(); i++) {
            backUpon(digits, index+1, sb.append(letter.charAt(i)));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
