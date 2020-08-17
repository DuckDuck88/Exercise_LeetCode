package leetCode.dp问题;


/**
 * @Program: LeetCode
 * @Description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @Author: YaYa
 * @Create: 2020-08-17 09:56
 */

public class 平衡二叉树 {
//    public boolean isBalanced(TreeNode root) {
//        if (root==null) return true;
//        return Math.abs(depth(root.left)-depth(root.right))<=1&&isBalanced(root.right)&&isBalanced(root.left);
//    }
//
//
//    private int depth(TreeNode node){
//        if (node==null) return 0;
//        return Math.max(depth(node.left)+1,depth(node.right)+1);
//    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }
}
