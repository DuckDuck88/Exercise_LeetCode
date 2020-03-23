package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName ReplaceSpace
     * @Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 18:13
 */
public class ReplaceSpace {
//    public String replaceSpace(String s) {
//
//        return  s.replaceAll("\\s","%20");
//    }

    public String replaceSpace(String s) {
        StringBuilder result=new StringBuilder();
        for (int i=1;i<s.length();i++){
            char cur=s.charAt(i);
            if (cur==' '){
                result.append("%20");
            }else{
                result.append(cur);
            }
        }
        return String.valueOf(result);
    }
}
