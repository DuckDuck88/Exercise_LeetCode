package leetCode.A_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Program: LeetCode
 * @ClassName LevelOrder
 * @Description: 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-26 14:45
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
            list.add(temp.val);
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
