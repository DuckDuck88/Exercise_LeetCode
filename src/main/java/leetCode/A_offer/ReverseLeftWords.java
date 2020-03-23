package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName ReverseLeftWords
 * @Description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 15:45
 */
public class ReverseLeftWords {
    //思路：将其转换为一个字符数组，然后将数组反转。
    public String reverseLeftWords(String s, int n) {
        char[] str=s.toCharArray();
        char[] result=new char[str.length];
        System.arraycopy(str, n,result, 0, str.length-n);
        System.arraycopy(str, 0, result, str.length-n, n);
        String strresult=new String(result);
        return strresult;

    }

}
