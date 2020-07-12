package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 编写一个程序，找到两个单链表相交的起始节点
 * @Author: YaYa
 * @Create: 2020-07-12 17:30
 */
public class 相交链表 {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set set=new HashSet();
//        while (headA!=null){
//           set.add(headA);
//           headA=headA.next;
//        }
//        while (headB!=null){
//            if (set.contains(headB)){
//                return headB;
//            }
//            headB=headB.next;
//        }
//        return null;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null || nodeB != null) {
            System.out.println("执行");
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return null;
    }
}
