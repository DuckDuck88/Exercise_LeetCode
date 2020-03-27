package writtenexamination.test_MeiTuan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Program: LeetCode
 * @ClassName 子序列计数
 * @Description: 一个序列是有趣的需要满足：当且仅当这个序列的每一个元素ai 满足 i 整除ai 。
 * 现在给定一个长度为n的数组，问这个数组有多少个非空的子序列是有趣的，
 * 由于答案可能比较大，只需要输出在模998244353意义下答案的就行了。
 * 一个长度为n的数组的非空子序列定义为从这个数组中移除至多n-1个元素后剩下的元素有序按照原顺序形成的数组。
 * 比如说对于数组[3,2,1]，它的非空子序列有[3],[2],[1],[3,2],[3,1],[2,1],[3,2,1]。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-26 20:26
 */
public class 子序列计数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int n= Integer.valueOf(s);
        int[] a_=new int[n];
        for (int i = 0; i < n; i++) {
            a_[i]=scanner.nextInt();
        }
        int x=0;
        ArrayList assist=help(a_, n);
        for (int i = 1; i < assist.size(); i++) {
            ArrayList<Integer> temp= (ArrayList<Integer>) assist.get(i);
            int[] m=new int[temp.size()];
            for (int j = 0; j < temp.size(); j++) {
                m[j]= temp.get(j);
            }
            if (helpyouqu(m))
                x=(x+1)%998244353;
        }
        System.out.println(x);
    }

    public static ArrayList<ArrayList<Integer>> help(int[] arr,int length){
        ArrayList<ArrayList<Integer>> bList=new ArrayList<>();
        int mark=0;
        int nEnd=1<<length;
        boolean bNullset=false;
        for (mark=0;mark<nEnd;mark++){
            ArrayList<Integer> aList=new ArrayList<>();
            bNullset=true;
            for (int i = 0; i < length; i++) {
                if (((1<<i)&mark)!=0){
                    bNullset=false;
                    aList.add(arr[i]);
                }
            }
            bList.add(aList);
        }
        return bList;
    }

    public static boolean helpyouqu(int[] nums){
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i]%i!=0)
                return false;
        }
        return true;
    }

}
