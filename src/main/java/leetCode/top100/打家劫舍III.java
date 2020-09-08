package leetCode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description: 在上次打劫完一条街道之后和一圈房屋后，
 * 小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * @Author: YaYa
 * @Create: 2020-09-08 13:58
 */
public class 打家劫舍III {
    Map<TreeNode, Integer> mapR = new HashMap<>();
    Map<TreeNode, Integer> mapN = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(mapN.getOrDefault(root, 0), mapR.getOrDefault(root, 0));
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        dfs(node.right);
        mapR.put(node, node.val +
                mapN.getOrDefault(node.left, 0) +
                mapN.getOrDefault(node.right, 0));
        mapN.put(node,
                Math.max(mapN.getOrDefault(node.left, 0),
                        mapR.getOrDefault(node.left, 0)) +
                        Math.max(mapN.getOrDefault(node.right, 0),
                                mapR.getOrDefault(node.right, 0)));
    }
}
