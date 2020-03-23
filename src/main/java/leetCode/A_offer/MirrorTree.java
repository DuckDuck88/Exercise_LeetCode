package leetCode.A_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Program: LeetCode
 * @ClassName MirrorTree
 * @Description: 请完成一个函数，输入一个二叉树，该函数 输出它的镜像。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 18:42
 */
public class MirrorTree {
    //递归
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root==null){
//            return null;
//        }
//        //先交换root的左右子树
//        TreeNode temp=root.left;
//        root.left=root.right;
//        root.right=temp;
//        mirrorTree(root.right);
//        mirrorTree(root.left);
//        return root;
//    }
    //利用队列
    public TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            //交换左右节点
            if (temp != null) {
                TreeNode tempNode = temp.left;
                temp.left = temp.right;
                temp.right = tempNode;
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return root;
    }
}
