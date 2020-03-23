package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName MergeTwoLists
 * @Description: 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-06 23:34
 */
public class MergeTwoLists {
    //1.使用额外空间
    //2.改动原链表
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1==null)
//            return l2;
//        else if (l2==null)
//            return l1;
//        else if (l1.val>=l2.val) {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }else if (l1.val<l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }
//        return null;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr=null;
        if (l1==null)
            return l2;
        else if (l2==null)
            return l1;
        else if (l1.val>=l2.val){
            curr.next=mergeTwoLists(l1, l2.next);
        }else if (l1.val<l2.val){
            curr.next=mergeTwoLists(l1.next, l2);
        }
        return curr;
    }
}
