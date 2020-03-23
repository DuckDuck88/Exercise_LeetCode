package leetCode.B_db_sort_death;

import org.junit.Test;

import java.util.Stack;

/**
 * @Program: LeetCode
 * @ClassName VerifyPostorder
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-22 23:23
 */
public class VerifyPostorder {
    //方法一：递归法，后序遍历的划分【左，右，根】
//    public boolean verifyPostorder(int[] postorder) {
//        if (postorder.length == 0) return true;
//        return helper(postorder, 0, postorder.length - 1);
//    }
//
//    private boolean helper(int[] postorder, int start, int root) {
//       if (start>root) return true;
//        int index = start;
//
//            while (postorder[index] < postorder[root]) {
//                index++;
//            }
//            for (int j = index; j < root; j++) {
//                if (postorder[j] < postorder[root]) {
//                    return false;
//                }
//            }
//        return helper(postorder, start, index - 1) && helper(postorder, index, root - 1);
//    }

    //方法二,单调栈
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 2) return true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(postorder[postorder.length - 1]);
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 2; i >= 0; i--) {
            if (postorder[i]>root) return false;
            while (!stack.isEmpty()&&postorder[i] < stack.peek()) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

    @Test
    public void test() {
        int[] num = {1, 2, 3, 4, 5};
        System.out.println(verifyPostorder(num));
    }
}
