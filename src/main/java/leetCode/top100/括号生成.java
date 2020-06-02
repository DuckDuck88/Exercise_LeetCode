package leetCode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * @Author: YaYa
 * @Create: 2020-05-07 16:57
 */
public class 括号生成 {
    //方法一：递归
//    public List<String> generateParenthesis(int n) {
//        List<String> list =new LinkedList<>();
//        if (n==0) return list;
//        helper(list,n,n,"");
//        return list;
//    }
//
//    public void helper(List list,int left,int right,String str){
//        if (left==0&&right==0) {
//            list.add(str);
//            return;
//        }
//        if (right<left)
//            return;
//        if (left>0){
//            helper(list, left-1, right, str+'(');
//        }
//        if (right>0){
//            helper(list, left, right-1, str+')');
//        }
//    }
    //方法二:动态规划
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp=new ArrayList<>();
        if (n==0) return new ArrayList<>();
        List<String> dp0=new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i =1; i <=n; i++) {
            List<String> curr=new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1=dp.get(j);
                List<String> str2=dp.get(i-1-j);
                for (String s1:str1){
                    for (String s2:str2){
                        curr.add("("+s1+")"+s2);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(n);
    }


    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
