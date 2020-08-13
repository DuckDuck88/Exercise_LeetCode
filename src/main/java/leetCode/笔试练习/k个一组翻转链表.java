package leetCode.笔试练习;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description: 给你一个链表，每 k 个节点一组进行翻转，请返回翻转后的链表。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 : 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * @Author: YaYa
 * @Create: 2020-08-13 11:10
 */
public class k个一组翻转链表 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        int k = sc.nextInt();
        ListNode head = new ListNode(0);
        ListNode t = head;
        k个一组翻转链表 temp = new k个一组翻转链表();
        for (int i : list) {
            t.next = new ListNode(i);
            t = t.next;
        }
        temp.reverseKGroup(head.next, k);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
