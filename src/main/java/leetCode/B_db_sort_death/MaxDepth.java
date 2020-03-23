package leetCode.B_db_sort_death;

import java.util.LinkedList;
import java.util.List;

/**
 * @Program: LeetCode
 * @ClassName MaxDepth
 * @Description: 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-23 20:28
 */
public class MaxDepth {
    //深度优先
//    public int maxDepth(TreeNode root) {
//        if (root==null) return 0;
//        if (root.left==null&&root.right==null) return 1;
//        int ldepth=maxDepth(root.left)+1;
//        int rdepth=maxDepth(root.right)+1;
//        return ldepth>rdepth?ldepth:rdepth;
//    }
    //层次遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<TreeNode> assist; //辅助队列
        int death=0;
        while (!queue.isEmpty()){
            assist=new LinkedList<>();
            for (TreeNode node:queue){
                if (node.left!=null) assist.add(node.left);
                if (node.right!=null) assist.add(node.right);
            }
            queue=assist;
            death++;
        }
        return death;
    }
}
