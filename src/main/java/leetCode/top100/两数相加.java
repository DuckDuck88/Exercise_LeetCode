package leetCode.top100;

import java.util.LinkedList;

/**
 * @Program: LeetCode
 * @Description: 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。   
 * 进阶：  如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转
 * @Author: YaYa
 * @Create: 2020-08-21 10:49
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.offer(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offer(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int c = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || c > 0) {
            int x = (stack1.isEmpty() ? 0 : stack1.pop())
                    + (stack2.isEmpty() ? 0 : stack2.pop())
                    + c;
            ListNode n = new ListNode(x % 10);
            c = x / 10;
            n.next = res;
            res = n;
        }
        return res;
    }
}
