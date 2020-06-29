package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个二叉树，原地将它展开为一个单链表。
 * @Author: YaYa
 * @Create: 2020-06-29 16:49
 */
public class 二叉树展开为链表 {
    /**
     *
     * @param root
     */
//    public void flatten(TreeNode root) {
//        if (root==null) return;
//        TreeNode tempRoot=root;
//        while (tempRoot!=null){
//            if (tempRoot.left==null){
//                tempRoot=tempRoot.right;
//            }else {
//                TreeNode pre=tempRoot.left;
//                while (pre.right!=null){
//                    pre=pre.right;
//                }
//                pre.right=tempRoot.right;
//                tempRoot.right=tempRoot.left;
//                tempRoot.left=null;
//                tempRoot=tempRoot.right;
//            }
//        }
//    }

    /**
     * 后序遍历
     * @param root
     */
    private TreeNode pre=null;
    public void flatten(TreeNode root) {
        if (root==null) return;
       flatten(root.right);
       flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }
}
