package leetCode.linkedlist;

/**
 * @Program: LeetCode
 * @ClassName MergeTwoLists
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-17 19:41
 */
public class MergeTwoLists {
//    //方法一，遍历两个链表，将两个链表有序插入新链表
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode result=new ListNode(-1);//头结点
//        ListNode indexResult=result;
//        while (l1 != null && l2 != null) {
//             if (l1.val <= l2.val) {
//                indexResult.next=l1;
//                l1=l1.next;
//            } else if (l1.val > l2.val) {
//                indexResult.next=l2;
//                l2=l2.next;
//            }
//            indexResult=indexResult.next;
//        }
//        indexResult.next=l1==null?l2:l1;
//        return result.next;
//    }

    //方法二，递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
