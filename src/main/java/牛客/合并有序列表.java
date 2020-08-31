package 牛客;

/**
 * @Program: LeetCode
 * @Description: 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
 * @Author: YaYa
 * @Create: 2020-08-27 10:47
 */
public class 合并有序列表 {

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode curr = res;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while (t1 != null && t2 != null) {
            if (t1.val >= t2.val) {
                curr.next = t2;
                t2 = t2.next;
            } else {
                curr.next = t1;
                t1 = t1.next;
            }
            curr = curr.next;
        }
        if (t1 == null && t2 == null) {
            return res.next;
        }
        curr.next = t1 == null ? t2 : t1;
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;
}

