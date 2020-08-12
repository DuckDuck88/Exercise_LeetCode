package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个二叉搜索树（Binary Search Tree），
 * 把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和
 * @Author: YaYa
 * @Create: 2020-08-12 10:45
 */
public class 把二叉搜索树转换为累加树 {
    /**
     * 相加顺序   根节点加右孩子，左孩子加根节点。
     * 相应递归顺序  root.right  root  root.left
     *
     * @param root
     * @return
     */
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
