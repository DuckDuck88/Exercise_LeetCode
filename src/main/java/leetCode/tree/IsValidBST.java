package leetCode.tree;

/**
 * @Program: LeetCode
 * @ClassName IsValidBST
 * @Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。  假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-23 21:07
 */
public class IsValidBST {
    /**
     * @description: 利用递归，DFS遍历树，同时比较值
     * @params: [root]
     * @return: boolean
     * @Author: Mr.Liu
     * @Date: 2020/2/23
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root,Long min,Long max){
        if (root==null) return true;
        if (root.val<=min||root.val>=max)
            return false;
        return helper(root.left, min, (long) root.val)&&helper(root.right, (long) root.val,max);
    }
}