package leetCode.A_offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Program: LeetCode
 * @ClassName pathSum
 * @Description:
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-26 17:41
 */
public class pathSum {
    LinkedList<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    //深度优先递归树，需要一个参数，为目前为止的和，边递归边计算
    public void dfs(TreeNode root,int target){
        if (root==null) return;
        path.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null)
            result.add(new LinkedList(path));
        dfs(root.left, target);
        dfs(root.right, target);
        path.removeLast();
    }
}
