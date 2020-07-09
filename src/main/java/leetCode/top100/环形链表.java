package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 给定一个链表，返回链表开始入环的第一个节点。 
 * 如果链表无环，则返回 null。  为
 * 了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。  说明：不允许修改给定的链表
 * @Author: YaYa
 * @Create: 2020-07-09 22:17
 */
public class 环形链表 {
    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        ListNode pre = head;
        ListNode result = null;
        while (pre != null && pre.next != null) {
            curr = curr.next;
            pre = pre.next.next;
            if (curr == pre) {
                result = curr;
                break;
            }
        }
        if (result == null) {
            System.out.println(123);
            return null;
        }
        ListNode temp = head;
        while (temp != result) {
            result = result.next;
            temp = temp.next;
        }
        return result;
    }
}
