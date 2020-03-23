package leetCode.A_offer;


/**
 * @Program: LeetCode
 * @ClassName ReverseList
 * @Description: 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-06 19:43
 */
public class ReverseList {
    //两种解法，快慢指针法和递归法
//    public ListNode reverseList(ListNode head) {
//        ListNode fast=head.next;
//        ListNode curr=head;
//        while (fast!=null){
//            ListNode temp=fast.next;
//            fast.next=curr;
//            curr=fast;
//            fast=temp;
//        }
//        return curr;
//    }
    public ListNode reverseList(ListNode head){
        if (head==null){
            return null;
        }
        ListNode start=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return start;
    }
}
