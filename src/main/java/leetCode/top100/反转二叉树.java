package leetCode.top100;

import java.util.LinkedList;

/**
 * @Program: LeetCode
 * @Description: 反转二叉树
 * @Author: YaYa
 * @Create: 2020-08-03 16:12
 */
public class 反转二叉树 {
    /**
     * 递归
     * @param root
     * @return
     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root==null) return null;
//        TreeNode right = invertTree(root.right);
//        TreeNode left = invertTree(root.left);
//        root.left=right;
//        root.right=left;
//        return root;
//    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
}
