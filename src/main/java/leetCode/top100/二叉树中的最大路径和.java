package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description:
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * @Author: YaYa
 * @Create: 2020-07-08 22:51
 */
public class 二叉树中的最大路径和 {
    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        helper(root);
        return max;
    }

    public int helper(TreeNode node){
        if (node==null) return 0;
        int left=Math.max(helper(node.left),0);
        int right=Math.max(helper(node.right),0);
        int curr=node.val+left+right;
        max=Math.max(max,curr);
        return node.val+Math.max(left,right);
    }
}
