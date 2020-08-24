package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000
 * @Author: YaYa
 * @Create: 2020-08-24 10:12
 */
public class 重复的子字符串 {

//    public boolean repeatedSubstringPattern(String s) {
//        //因为符合题目要求的s字符串的子串最少重复两次
//        // 所以在（s+s）中子串最少出现四次，四个子串最少可以找出三个起始位置不同的s，
//        //例如 abababab
//        //去掉首字母后，在（s+s）中寻找s，如果找到的s的下标不等于第二个s的起始坐标
//        // 说明在（s+s）中存在第三个s，字符串符合条件
//        return (s+s).indexOf(s, 1)!=s.length();
//    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 0) return false;
        boolean flag = false;
        for (int i = 1; i * 2 < len; i++) {
            if (len % i == 0) {
                flag = true;
                for (int j = i; j < len; j++) {
                    if (s.charAt(j) != s.charAt(j % i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }


}
