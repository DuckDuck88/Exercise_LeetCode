package 牛客;

/**
 * @Program: LeetCode
 * @Description: 判断给定的链表中是否有环 扩展： 你能给出空间复杂度的解法么？
 * @Author: YaYa
 * @Create: 2020-08-27 13:11
 */
public class 判断链表中是否有环 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode curr = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            curr = curr.next;
            if (curr == fast)
                return true;
        }
        return false;
    }
}
