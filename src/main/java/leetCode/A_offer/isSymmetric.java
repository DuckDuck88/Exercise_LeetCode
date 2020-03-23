package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName isSymmetric
 * @Description: 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-28 23:21
 */
public class isSymmetric {
    //方法一：用一个辅助函数，两个参数，份别代表两颗左右子树。在这个函数里比较这两个根节点的值。
//    public boolean isSymmetric(TreeNode root) {
//        return helper(root, root);
//    }
//
//    private boolean helper(TreeNode left, TreeNode right){
//        if (left==null&&right==null){
//            return true;
//        }
//        if (left==null||right==null){
//            return false;
//        }
//        if (left.val!=right.val){
//            return false;
//        }
//        return helper(left.left, right.right)&&helper(left.right, right.left);
//    }

    //方法二：类似方法一 使用队列，将对称的值先后加入队列。队列输出时，如果连续两个结果不一样，则false
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> myQueue=new LinkedList();
//        TreeNode curr=root;
//        myQueue.A_offer(curr);
//        myQueue.A_offer(curr);
//        while (!myQueue.isEmpty()){
//            TreeNode temp1=myQueue.poll();
//            TreeNode temp2=myQueue.poll();
//            if (temp1==null&&temp2==null) continue;
//            if (temp1==null||temp2==null) return false;
//            if (temp1.val!=temp2.val) return false;
//            myQueue.A_offer(temp1.left);
//            myQueue.A_offer(temp2.right);
//            myQueue.A_offer(temp1.right);
//            myQueue.A_offer(temp2.left);
//        }
//        return true;
//    }

    //方法三：使用前序遍历和后序遍历遍历两次树。将遍历结果放在一个数组中。遍历结果相同则对称
//    public boolean isSymmetric(TreeNode root) {
//
//    }
}
