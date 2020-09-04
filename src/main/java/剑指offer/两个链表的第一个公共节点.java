package 剑指offer;

/**
 * @Program: LeetCode
 * @Description: 输入两个链表，找出它们的第一个公共节点。
 * @Author: YaYa
 * @Create: 2020-09-04 10:45
 */
public class 两个链表的第一个公共节点 {

    /**
     * 两种方法  一是分别递归到底部，然后逐个返回  不满足 o1内存
     * 二是将两个链表首尾相连，他们在第一个相同的节点相遇时，走的步数一定相同。
     *
     * @param headA
     * @param headB
     * @return
     */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode nodeA = headA, nodeB = headB;
//        ListNode t1 = headA;
//        ListNode t2 = headB;
//        int lA = 0, lB = 0;
//        while (nodeA.next != null) {
//            nodeA = nodeA.next;
//            lA++;
//            System.out.println(lA);
//        }
//        while (nodeB.next != null) {
//            nodeB = nodeB.next;
//            lB++;
//            System.out.println(lB);
//        }
//        nodeA.next = headB;
//        nodeB.next = headA;
//        for (int i = 0; i < lA + lB; i++) {
//            t1 = t1.next;
//            t2 = t2.next;
//            if (t1.val == t2.val)
//                return t1;
//        }
//        nodeA.next = null;
//        nodeB.next = null;
//        return null;
//    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}
