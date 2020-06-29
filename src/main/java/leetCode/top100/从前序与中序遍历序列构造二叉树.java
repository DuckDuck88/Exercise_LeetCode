package leetCode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description: 根据一棵树的前序遍历与中序遍历构造二叉树。
 * @Author: YaYa
 * @Create: 2020-06-29 15:32
 */
public class 从前序与中序遍历序列构造二叉树 {

    /**
     * 前序遍历 根 左 右
     * 中序遍历 左 根 右
     * 后序遍历 左 右 根
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildMyTree(preorder, inorder, 0, preorder.length, 0, inorder.length, map);
    }

    private TreeNode buildMyTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inoLeft, int inoRight, Map<Integer, Integer> map) {
        if (preLeft >= preRight || inoLeft >= inoRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = map.get(preorder[preLeft]);
        int size = index - inoLeft;
        // 左闭右开 [ ）
        root.left = buildMyTree(preorder, inorder, preLeft + 1, preLeft+size+1, inoLeft, index, map);
        root.right = buildMyTree(preorder, inorder, preLeft + size + 1, preRight, index+1, inoRight, map);
        return root;
    }
}
