package leetCode.A_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Program: LeetCode
 * @ClassName LevelOrder2
 * @Description: 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-26 15:13
 */
public class LevelOrder2 {
    //方法一，正常输出，最后将奇数层的list反转
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return new LinkedList<>();
//        List<List<Integer>> result = new LinkedList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int theLayerNumber = 1;    //标记层数是奇数还是偶数
//        while (!queue.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            Queue<TreeNode> assist = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                TreeNode node = queue.poll();
//                if (node.left != null) assist.add(node.left);
//                if (node.right != null) assist.add(node.right);
//                list.add(node.val);
//            }
//            queue = assist;
//            if (theLayerNumber++ % 2 == 0) {
//                Collections.reverse(list);
//            }
//            result.add(list);
//        }
//        return result;
//    }

    //方法一优化
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            if (result.size() % 2 != 0)
                Collections.reverse(list);
            result.add(list);
        }
        return result;
    }

}
