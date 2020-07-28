package leetCode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: LeetCode 6
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列
 * @Author: YaYa
 * @Create: 2020-07-22 09:49
 */
public class Z字形变换 {
    /**
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        List<StringBuilder> list = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        //用于标记方向和管理指针长度
        int flag = -1;
        //指针，指向当前要放入的行
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.get(pointer).append(c);
            if (pointer == 0 || pointer == numRows - 1) {
                flag = -flag;
            }
            pointer += flag;
        }
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return result.toString();
    }

}
