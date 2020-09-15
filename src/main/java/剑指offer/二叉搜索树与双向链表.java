package 剑指offer;

/**
 * @Description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @Date 2020/9/15 10:56
 * @ClassName 二叉搜索树与双向链表
 * @Created by 是哪的鸭
 */
public class 二叉搜索树与双向链表 {
    /*
     * @description:对数的操作优先想三种遍历，其中二叉搜索树的中序遍历是升序。
     * @param: 根节点
     * @return:
     * @date: 2020/9/15 12:36
     * @created by 是哪的鸭
     */
    private Note head, pre;

    public Note treeToDoublyList(Note root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Note curr) {
        if (curr == null) return;
        dfs(curr.left);
        if (pre == null) {
            head = curr;
            curr.left = pre;
        } else {
            pre.right = curr;
            curr.left = pre;
        }
        pre = curr;
        dfs(curr.right);
    }
}


class Note {
    public int val;
    public Note left;
    public Note right;

    public Note() {

    }

    public Note(int _val) {
        val = _val;
    }

    public Note(int _val, Note _left, Note _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
