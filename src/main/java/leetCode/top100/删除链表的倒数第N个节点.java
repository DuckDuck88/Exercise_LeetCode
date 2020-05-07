package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 * @Author: YaYa
 * @Create: 2020-05-01 10:20
 */
public class 删除链表的倒数第N个节点 {
    //双指针
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode curr=head,end=head;
//        for (int i = 0; i < n; i++) {
//            end=end.next;
//        }
//        if (end==null) return head.next;
//        while (end.next!=null){
//            curr=curr.next;
//            end=end.next;
//        }
//        curr.next=curr.next.next;
//        return head;
//    }
    //递归
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int num=helper(head,n);
        if (num==n)
            return head.next;
        return head;
    }

    public static int helper(ListNode node,int n){
        if (node==null) return 0;
        int num=helper(node.next, n)+1;
        if (num==n-1) {
            node.next = node.next.next;
        }
        return num;
    }
}
