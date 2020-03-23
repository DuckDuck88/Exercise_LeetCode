package leetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Program: LeetCode
 * @ClassName LevelOrder
 * @Description: 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-23 18:42
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list =new LinkedList<>();
        if (root==null) return list;
        while (!queue.isEmpty()){
            List<Integer> currList=new LinkedList<>();
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode currNote=queue.poll();
                currList.add(currNote.val);
                if (currNote.left!=null){
                    queue.offer(currNote.left);
                }
                if (currNote.right!=null){
                    queue.offer(currNote.right);
                }
                if (i==size-1)
                    list.add(currList);
            }
        }
        return list;
    }
}
