package leetCode.tree;

/**
 * @Program: LeetCode
 * @ClassName IsSymmetric
 * @Description: 给定一个二叉树，检查它是否是镜像对称的。  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-26 01:51
 */
public class IsSymmetric {
    //迭代  使用队列
//    public boolean isSymmetric(TreeNode root) {
//        if (root==null) return true;
//        Queue<TreeNode> queue=new LinkedList<TreeNode>();
//        queue.A_offer(root);
//        queue.A_offer(root);
//        while (!queue.isEmpty()){
//            TreeNode t1=queue.poll();
//            TreeNode t2=queue.poll();
//            if (t1==null&&t2==null) continue;
//            if (t1==null||t2==null) return false;
//            if (t1.val!=t2.val) return false;
//            queue.A_offer(t1.left);
//            queue.A_offer(t2.right);
//            queue.A_offer(t1.right);
//            queue.A_offer(t2.left);
//        }
//        return true;
//    }

    //方法二 使用递归
    public boolean isSymmetric(TreeNode root) {
        return root==null? true:helper(root,root);
    }

    public boolean helper(TreeNode t1,TreeNode t2){
        if (t1==null&&t2==null) return true;
        if (t1==null||t2==null) return false;
        if (t1.val!=t2.val) return false;
        return helper(t1.left, t2.right)&&helper(t1.right, t2.left);
    }
}
