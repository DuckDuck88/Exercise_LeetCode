package leetCode.top100;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @Description: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @Author: YaYa
 * @Create: 2020-05-30 16:54
 */
public class 最长有效括号 {
    /**
     * @description:
     * @params: [s]
     * @return: int
     * @Author: Mr.Liu
     * @Date: 2020/6/1
     */
//    public int longestValidParentheses(String s) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.push(-1);
//        int len = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                list.push(i);
//            } else {
//                list.pop();
//                if (list.isEmpty()){
//                    list.push(i);
//                }else {
//                    int t = list.peek();
//                    len = Math.max(len, i - t);
//                }
//            }
//        }
//        return len ;
//    }

    /**
     * @description: 动态规划 d[i]代表此时的长度
     * @params: []
     * @return: void
     * @Author: Mr.Liu
     * @Date: 2020/6/2
     */
//    public int longestValidParentheses(String s) {
//        int[] d = new int[XXs.length()];
//        int max=0;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                d[i] = 0;
//            } else if (s.charAt(i - 1) == '(') {
//                d[i] = ((i - 2) >= 0 ? d[i - 2] : 0) + 2;
//            } else if ((i - d[i - 1]) > 0 && s.charAt(i - d[i - 1] - 1) ==  '('){
//                d[i]=d[i-1]+2+((i-d[i-1]-2)>=0?d[i-d[i-1]-2]:0);
//            }
//            max=Math.max(max, d[i]);
//        }
//        return max;
//    }

    /**
    * @description: 从左往右和从右往左计算两次 左右括号数量。取最大
     * 对于无效括号，有两种情况特殊情况  。。。。））和（（。。。。即左括号多和右括号多。
     * 从左往右计算时，在无效括号这部分，左右数量永远不会相等，故不会计算
     * 从右往左计算时，在无效括号这部分，左右数量永远不会相等，故不会计算
    * @params: []
    * @return: void
    * @Author: Mr.Liu
    * @Date: 2020/6/2
    */
    public int longestValidParentheses(String s) {
        int left=0,right=0,maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if (left==right){
                maxLen=Math.max(2*left,maxLen);
            }
            if (right>left){
                left=right=0;
            }
        }
        left=right=0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)=='('){
                right++;
            }else {
                left++;
            }
            if (left==right){
                maxLen=Math.max(2*left,maxLen);
            }
            if (right>left){
                left=right=0;
            }
        }
        return maxLen;
    }
    @Test
    public void testDemo() {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
}