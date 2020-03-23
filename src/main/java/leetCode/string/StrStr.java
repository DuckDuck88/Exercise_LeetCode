package leetCode.string;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName StrStr
 * @Description: 实现 strStr() 函数。  给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-17 14:27
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        //如果needle为空则返回0
        if (needle.equals(""))
            return 0;
        //将haystack和needle转为字符数组
        char[] text = haystack.toCharArray();
        char[] target = needle.toCharArray();
        //判断边界，当查找至这里时往后无结果
        int max = text.length - target.length;
        //边界大于0时循环至边界,循环完未发现则返回-1；
        if (max >= 0) {
            for (int i = 0; i <= max; i++) {
                //找到第一个相同的字母
                int j = 0;//target的位置
                if (target[j] != text[i]) {
                    while (text[i] != target[j] && i <= max) {
                        i++;
                        if (i == max && text[i] != target[j])
                            return -1;
                    }
                }
                int index = i;//记录本次第一个字母相同的位置,如果后续判断字符串相同则返回此位置
                int start = i;//用于后续text的判断
                //依次比较下一个字母。不同则退出循环
                for (; j < target.length; start++, j++) {
                    if (text[start] != target[j] ) {
                        break;
                    }
                }
                //如果j等于target+1的长度，说明完成一次完整循环，存在相同字符串，返回index
                if (j == target.length) {
                    return index;
                }
            }
        }
        return -1;
    }


    @Test
    public void  testDemo(){
        System.out.println(strStr("hello","ll"));
    }
}
