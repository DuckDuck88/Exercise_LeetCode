package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @Author: YaYa
 * @Create: 2020-08-08 17:06
 */
public class 二叉树的直径 {
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result=0;
        helper(root);
        return result;
    }

    private int helper(TreeNode node){
        if (node==null) return 0;
        int l = helper(node.right);
        int r = helper(node.left);
        result=Math.max(result, l+r);
        return Math.max(l, r)+1;
    }

}
