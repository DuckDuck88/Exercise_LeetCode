package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * @Author: YaYa
 * @Create: 2020-08-31 09:46
 */
public class 二叉搜索树的最近公共祖先 {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        while (root != null) {
//            if (root.val > p.val && root.val > q.val)
//                root = root.left;
//            if (root.val < p.val || root.val < q.val)
//                root = root.right;
//        }
//        return root;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
