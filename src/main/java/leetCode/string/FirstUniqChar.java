package leetCode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: LeetCode
 * @ClassName FirstUniqChar
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-15 22:53
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] ss=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>(ss.length);
        for (char c:ss){
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }

        for (int i=0;i<ss.length;i++){
            if (map.containsKey(ss[i])&&map.get(ss[i])==1){
                return i;
            }
        }
        return -1;
    }
}
