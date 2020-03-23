package leetCode.linkedlist;

/**
 * @Program: LeetCode
 * @ClassName ReverseList
 * @Description: 反转一个单链表。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-17 17:19
 */

public class ReverseList {
//    //双指针法，将指向反转
//    public ListNode reverseList(ListNode head) {
//        //一个指向头节点，一个为null
//        ListNode pre=null;
//        ListNode curr=head;
//        while (curr!=null){
//            //临时记录curr.next。防止curr.next更改指向后丢失
//            ListNode temp=curr.next;
//            //改变指向
//            curr.next=pre;
//            //向后移动两个指针
//            pre=curr;
//            curr=temp;
//        }
//        return pre;
//    }

    //递归法
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode start=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return start;
    }
}
