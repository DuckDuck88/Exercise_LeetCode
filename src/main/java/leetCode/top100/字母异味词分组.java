package leetCode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description: 给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串
 * @Author: YaYa
 * @Create: 2020-06-14 12:22
 */
public class 字母异味词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Map<Character,Integer> m=new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                m.put(strs[i].charAt(j),m.getOrDefault(strs[i].charAt(j), 0)+1);
            }
            List list=map.getOrDefault(m, new LinkedList<String>());
            list.add(strs[i]);
            map.put(m,list);
        }
        return new ArrayList<>(map.values());
    }

    @Test
    public void test(){
        String[] s={"boo","bob","axx","axa"};
        System.out.println(groupAnagrams(s));
    }
}
