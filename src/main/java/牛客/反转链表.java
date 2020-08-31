package 牛客;

/**
 * @Program: LeetCode
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 * @Author: YaYa
 * @Create: 2020-08-27 13:21
 */
public class 反转链表 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }

//    public ListNode ReverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode curr = head;
//        ListNode pre = null;
//        ListNode behind = null;
//
//        while (curr != null) {
//            behind=curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = behind;
//        }
//        return pre;
//    }
//
}
