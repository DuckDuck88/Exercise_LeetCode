package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: LeetCode
 * @ClassName InorderTraversal
 * @Description: 给定一个二叉树，返回它的中序 遍历
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-28 01:31
 */
public class InorderTraversal {
    //用递归最简单，但是这里主要是想学习一下莫里斯解法
    //中序遍历  先左 后根 最后右
    //先使用递归写
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list=new ArrayList<>();
//        helper(root, list);
//        return list;
//    }
//
//    public void helper(TreeNode root,List<Integer> list){
//        if (root!=null){
//            helper(root.left, list);
//            list.add(root.val);
//            helper(root.right, list);
//        }
//    }

    //方法二:使用栈
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list =new ArrayList<>();
//        LinkedList<TreeNode> stack=new LinkedList();
//        TreeNode curr=root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr=stack.poll();
//
//            list.add(curr.val);
//            curr=curr.right;
//        }
//        return list;
//    }

    //方法三：莫里斯解法
    public List<Integer> inorderTraversal(TreeNode root) {
        //使用两个辅助指针
        List<Integer> list=new ArrayList<>();
        TreeNode curr=root;
        TreeNode pre=null;
        while (curr!=null){
            if (curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }else {
                pre=curr.left;
                //寻找到当前结点在中序遍历下的前驱结点
                while (pre.right!=null&&pre.right!=curr){
                    pre=pre.right;
                }
                //将当前结点的前驱结点指向当前结点
                if(pre.right!=curr){
                    pre.right=curr;
                    curr=curr.left;
                }else {
                    list.add(curr.val);
                    curr=curr.right;
                    pre.right=null;
                }
            }
        }
        return list;
    }

}
