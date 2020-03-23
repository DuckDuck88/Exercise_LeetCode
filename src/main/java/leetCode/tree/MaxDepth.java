package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Program: LeetCode
 * @ClassName MaxDepth
 * @Description: 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-22 17:38
 */
public class MaxDepth {
    /**
    * @description: 方法一：递归实现深度优先
    * @params: [root] 根节点
    * @return: int   深度
    * @Author: Mr.Liu
    * @Date: 2020/2/23
    */
//    public int maxDepth(TreeNode root) {
//        if (root.left==null&&root.right==null){
//            return 0;
//        }
//        int depthl=maxDepth(root.left);
//        int depthr=maxDepth(root.right);
//        return depthl>depthr? depthl+1:depthr+1;
//    }
    /**
    * @description: 广度优先求最大深度，每一个层次为一个深度
    * @params: [root] 根节点
    * @return: int 深度
    * @Author: Mr.Liu
    * @Date: 2020/2/23
    */
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {

            int numberOfLevel = queue.size();
            for (int i = 0; i < numberOfLevel; i++) {
                TreeNode currNote = queue.poll();
                if (currNote.left!= null) {
                    queue.add(currNote.left);
                }
                if (currNote.right!=null){
                    queue.add(currNote.right);
                }
            }
            level++;
        }
        return level;
    }
}
