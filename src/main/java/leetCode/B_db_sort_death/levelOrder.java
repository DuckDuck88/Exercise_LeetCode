package leetCode.B_db_sort_death;

import java.util.LinkedList;
import java.util.List;

/**
 * @Program: LeetCode
 * @ClassName levelOrder
 * @Description: 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-23 21:11
 */
public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new LinkedList<>();
        List<List<Integer>> result=new LinkedList<>();
        List<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<TreeNode> assite;
        while (!queue.isEmpty()){
            assite=new LinkedList<>();
            List<Integer> list=new LinkedList<>();
            for(TreeNode node:queue){
                if (node.left!=null) assite.add(node.left);
                if (node.right!=null) assite.add(node.right);
                list.add(node.val);
            }
            result.add(list);
            queue=assite;
        }
        return result;
    }
}
