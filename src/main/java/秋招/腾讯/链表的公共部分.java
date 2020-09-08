package 秋招.腾讯;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description: 求链表的公共部分
 * @Author: YaYa
 * @Create: 2020-09-06 20:02
 */
public class 链表的公共部分 {
    public static void main(String[] args) {
        链表的公共部分 obj = new 链表的公共部分();
        ListNode[] list = new ListNode[2];
        list = obj.input();
        LinkedList<Integer> res = new LinkedList();
        ListNode ta = list[0].next;
        ListNode tb = list[1].next;
        while (ta != null && tb != null) {
            if (ta.val == tb.val) {
                res.addLast(ta.val);
                ta = ta.next;
                tb = tb.next;
            } else if (ta.val < tb.val) {
                tb = tb.next;
            } else {
                ta = ta.next;
            }
        }
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }

    public ListNode[] input() {
        Scanner scanner = new Scanner(System.in);
        ListNode[] head = new ListNode[2];
        head[0] = new ListNode(0);
        head[1] = new ListNode(0);
        int m = scanner.nextInt();
        ListNode curr1 = head[0];
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            ListNode tempa = new ListNode(t);
            curr1.next = tempa;
            curr1 = tempa;
        }
        int n = scanner.nextInt();
        ListNode curr2 = head[1];
        for (int i = 0; i < n; i++) {
            ListNode tempb = new ListNode(scanner.nextInt());
            curr2.next = tempb;
            curr2 = tempb;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
