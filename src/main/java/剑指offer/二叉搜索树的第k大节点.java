package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @Author: YaYa
 * @Create: 2020-09-01 10:59
 */
public class 二叉搜索树的第k大节点 {
    public int kthLargest(TreeNode root, int k) {
        int right = 0;
        if (root.right != null)
            right = helper(root.right);
        if (k == right + 1)
            return root.val;
        else if (k < right + 1)
            return kthLargest(root.right, k);
        else if (k > right + 1)
            return kthLargest(root.left, k - right - 1);
        return root.val;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = 0, right = 0;
        if (node.left != null)
            left = helper(node.left);
        if (node.right != null)
            right = helper(node.right);
        return left + right + 1;
    }
}
