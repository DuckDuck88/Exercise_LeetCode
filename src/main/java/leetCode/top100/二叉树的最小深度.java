package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。  说明: 叶子节点是指没有子节点的节点。
 * @Author: YaYa
 * @Create: 2020-08-21 14:14
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left != 0 && right != 0)
            return Math.min(left, right) + 1;
        return Math.max(left, right) + 1;
    }

    public int helper(TreeNode node) {
        if (node == null)
            return 0;
        int len = 0;
        int l = helper(node.left);
        int r = helper(node.right);
        len = ((l == 0) ? r : (r == 0) ? l : Math.min(l, r)) + 1;
        return len;
    }
}
