package leetCode.A_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: LeetCode
 * @ClassName buildTree
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-01 00:52
 */
public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] curpre=preorder;
        return helper(0, 0, inorder.length-1, map,curpre);
    }

    public TreeNode helper(int rootIndex, int inoleft, int inoright, Map<Integer,Integer> map,int[] preorder){
        if (inoleft> inoright)
            return null;
        TreeNode root=new TreeNode(preorder[rootIndex]);
        int tempindex=map.get(preorder[rootIndex]);
        root.left=helper(rootIndex+1, inoleft, tempindex-1, map, preorder);
        root.right=helper(rootIndex+tempindex-inoleft+1, tempindex+1, inoright, map, preorder);
        return root;
    }
}

