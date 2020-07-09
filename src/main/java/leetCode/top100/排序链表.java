package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 * @Author: YaYa
 * @Create: 2020-07-09 23:20
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tempHead = slow.next;
        slow.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(tempHead);
        ListNode H = new ListNode(0);
        ListNode temp = H;
        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                temp.next = h2;
                h2 = h2.next;
            } else {
                temp.next = h1;
                h1 = h1.next;
            }
            temp = temp.next;
        }
        temp.next = h1 == null ? h2 : h1;
        return H.next;
    }
}
