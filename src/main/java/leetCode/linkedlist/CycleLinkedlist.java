package leetCode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Program: LeetCode
 * @ClassName CycleLinkedlist
 * @Description: 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-19 16:20
 */
public class CycleLinkedlist {
//    /*
//     * 方法一：快慢指针法，快指针每次前进两格，满指针每次前进一格。
//     * 如果快慢指针相遇，则有环。如果快指针=null则无环
//     * */
//    public boolean hasCycle(ListNode head) {
//        ListNode fast=head;
//        ListNode slow=head;
//        while (fast!=null||fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if (slow==fast){
//                return true;
//            }
//        }
//        return false;
//    }
    /*
    *方法二，利用额外的空间，存储遍历过的结点，当next结点已经遍历过，则有环。
    *判断空间用哈希表
    * */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        ListNode curr=head;
        while (curr!=null){
            if (set.contains(curr)){
                return true;
            }
            set.add(curr);
            curr=curr.next;
        }
        return false;
    }


}
